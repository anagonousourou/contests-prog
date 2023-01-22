(ns bob)

(defn response-for [s] ;; <- arglist goes here
  (let [s-no-whitespace (.strip s)
        check-uppercase (fn [n] (if (Character/isLetter n) (Character/isUpperCase n) true)) ;; check if a letter character is upper case, returns true if the character is not a letter
        uppercase-sentence? (and (some (fn [n] (Character/isLetter n)) s-no-whitespace) (every? check-uppercase s-no-whitespace))]
    (cond
      (.isBlank s-no-whitespace) "Fine. Be that way!" ;;
      (and (.endsWith s-no-whitespace "?") uppercase-sentence?) "Calm down, I know what I'm doing!"
      (.endsWith s-no-whitespace "?") "Sure."
      uppercase-sentence?  "Whoa, chill out!" ;; every? return true when the collection is empty
      :else "Whatever.")))
