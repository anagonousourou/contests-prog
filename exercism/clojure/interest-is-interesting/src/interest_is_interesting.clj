(ns interest-is-interesting)

(defn interest-rate
  "return the interest-rate"
  [balance]
  (cond
    (neg? balance) -3.213 ;; -1,03213
    (< balance 1000M) 0.5
    (or (= 1000M balance) (< 1000M balance 5000M))  1.621 ;; need casting to bigdec because (= 1000 1000.M) is false
    (<= 5000M balance) 2.475))

(defn annual-balance-update
  "compute the balance at the end of the year"
  [balance]
  (let [actual-rate (/ (bigdec (interest-rate balance)) 100.0M) ;;  transform the percentage into an actual number, cast to bigdec to make sure a have the precisions
        interest-rate-mult  (if (neg? actual-rate) (+ 1.0M (- actual-rate)) (+ 1.0M actual-rate)) ;; add 1 to that number to turn the computation into a simple multiplication
        ]
    (bigdec (* balance interest-rate-mult))))

(defn amount-to-donate
  "compute amount to donate to charity"
  [balance tax-free-percentage]
  (if (neg? balance)
    0 ;; do not give money if you don't have any
    (let [actual-rate (/ tax-free-percentage 100.0M)]
      (int (* 2 balance actual-rate)))))