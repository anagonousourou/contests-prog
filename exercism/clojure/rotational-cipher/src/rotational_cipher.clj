(ns rotational-cipher)


(defn ->cipher-alphabet
  "Rotate a string XS-string by k toward the left
  Eg: (rotate 'abcd' 2) -> 'cdab'
  "
  [xs-string, k]
  (let [n (count xs-string)
        k (mod k n)]
    (str (subs xs-string k) (subs xs-string 0 k))))

(defn rotate [s k]
  (let [cipher (zipmap "abcdefghijklmnopqrstuvwxyz" (->cipher-alphabet "abcdefghijklmnopqrstuvwxyz" k))]
    (->> s
         (map (fn [c-char]  (if (Character/isLowerCase c-char) (get cipher (Character/toLowerCase c-char) c-char)
                                (Character/toUpperCase (get cipher (Character/toLowerCase c-char) c-char)))))
         (clojure.string/join))))