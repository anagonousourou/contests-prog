(ns gigasecond)

(defn from [year month day]  ;; <- arglist goes here
    ;; your code goes here
  (let [next-date (. (java.time.LocalDateTime/of year month day 0 0) plus  (java.time.Duration/ofSeconds 1000000000))]
    [(. next-date getYear) (. next-date getMonthValue) (. next-date getDayOfMonth)]))
