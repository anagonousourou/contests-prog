(ns codewars.human-readable-duration-format)

(def SECONDS_IN_YEARS (* 365  24  60  60))
(def SECONDS_IN_DAYS (* 24 60 60))


(defn secs->years [rem-secs]
  (if (>= rem-secs SECONDS_IN_YEARS)
    (let [nb-year (quot rem-secs SECONDS_IN_YEARS)]
      {
       :result (format "%d year%s" nb-year (if (> nb-year 1) "s" ""))
       :secs SECONDS_IN_YEARS
       }
      )
    {:result "", :secs (rem rem-secs SECONDS_IN_YEARS)}
    )
  )

(defn secs->unit [{:keys [result secs] :as previous}, {:keys [secs-in-unit, unit-name]}]
  (let [nb-unit (quot secs secs-in-unit)
        rem-secs (rem secs secs-in-unit)
        ]
    (cond
      ;; no conversion to do
      (zero? nb-unit) previous
      ;;there was no conversion until now and this won't be the last conversion
      (and (pos? nb-unit) (pos? rem-secs) (empty? result))    {
                                                              :secs rem-secs
                                                              :result (format "%d %s%s" nb-unit unit-name (if (> nb-unit 1) "s" ""))
                                                              }
      ;;there was no conversion until now and this will be the last conversion
      (and (pos? nb-unit) (zero? rem-secs) (empty? result))    {
                                                               :secs rem-secs
                                                               :result (format "%d %s%s" nb-unit unit-name (if (> nb-unit 1) "s" ""))
                                                               }
      ;; there was a previous conversion and this won't be the last conversion
      (and (pos? nb-unit) (pos? rem-secs) ((comp not empty?) result)) {
                                                                        :secs rem-secs
                                                                        :result (format "%s, %d %s%s" result nb-unit unit-name (if (> nb-unit 1) "s" ""))
                                                                      }
      ;; there was a previous conversion and this will be the last conversion
      (and (zero? rem-secs) ((comp not empty?) result)) {
                                                         :secs 0
                                                         :result (format "%s and %d %s%s" result nb-unit unit-name (if (> nb-unit 1) "s" ""))
                                                         }
      :else "Error"
      )
    )
  )

(defn formatDuration [secs]
  (if (zero? secs) "now"
                   (-> {:result "", :secs secs}
                       (secs->unit {:unit-name "year" :secs-in-unit SECONDS_IN_YEARS})
                       (secs->unit {:unit-name "day" :secs-in-unit SECONDS_IN_DAYS})
                       (secs->unit {:unit-name "hour" :secs-in-unit 3600})
                       (secs->unit {:unit-name "minute" :secs-in-unit 60})
                       (secs->unit {:unit-name "second" :secs-in-unit 1})
                       (:result)
                       )
                   )
  )