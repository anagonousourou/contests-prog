(ns codewars.count-change)

(defn- inc-map [changes coin]
  (update changes coin (fn [x] (if (nil? x) 1 (inc x)))))

(defn- my-count-change
  ([remaining-money, coins] (my-count-change remaining-money {} coins))
  ([remaining-money, changes, coins]
   (for [coin coins]
     (cond
       (= remaining-money coin) (inc-map changes coin)
       (< remaining-money coin) {}
       (> remaining-money coin) (my-count-change (- remaining-money coin) (inc-map changes coin) coins))))
  )

(defn count-change
  "Gives the number of ways to make change for some money given a set of coins"
  [money coins]
   (if (zero? money) 1
                     (->> (my-count-change money coins) ;; find the changes combination
                            (flatten)
                            (filter (comp not empty?)) ;; remove the non-solution
                            (distinct) ;; get distinct solutions
                            (count)))
)