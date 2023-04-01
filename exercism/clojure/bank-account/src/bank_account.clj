(ns bank-account)

(defn open-account [] ;; <- arglist goes here
  (ref 0)
  )

(defn close-account [bank-account] ;; <- arglist goes here
  (dosync (ref-set bank-account nil))
  )

(defn get-balance [bank-account] ;; <- arglist goes here
  @bank-account
  )

(defn update-balance [bank-account, amount] ;; <- arglist goes here
  (dosync (commute bank-account + amount))
  )
