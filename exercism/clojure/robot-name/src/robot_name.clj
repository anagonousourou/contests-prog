(ns robot-name)

(def used-names (ref #{}))
(defn- rand-uppercase-letter []
  (-> (inc (- 90 65))
      (rand-int)
      (+ 65)
      (char)))

(defn- random-name-simple []
  (format "%s%s%d" (rand-uppercase-letter) (rand-uppercase-letter) (+ 100 (rand-int 900))))


(defn- random-name []
  (let [new-name (ref (random-name-simple) ) ]
    (while (contains? @used-names @new-name)
      (ref-set new-name (random-name-simple))
      )
    (dosync (alter used-names conj @new-name))
    @new-name
    )
  )


(defn robot []
  (ref (random-name))
)

(defn robot-name [robot]
      @robot
)

(defn reset-name [robot] ;; <- arglist goes here
  (dosync (ref-set robot (random-name)))
)
