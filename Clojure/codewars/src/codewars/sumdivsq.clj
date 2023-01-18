(ns codewars.sumdivsq
  "1, 246, 2, 123, 3, 82, 6, 41 are the divisors of number 246.
  Squaring these divisors we get: 1, 60516, 4, 15129, 9, 6724, 36, 1681.
  The sum of these squares is 84100 which is 290 * 290.
  Task:
  Find all integers between m and n (m and n integers with 1 <= m <= n) such that the sum of
  their squared divisors is itself a square. ")

(defn- get-divisors [n]
  (conj (vec (filter #(zero? (mod n %)) (range 1 (inc (quot n 2))))) n)
  ;;^there is no divisors of n between in ]n/2; n[
  )

(defn- square? [n]
  (let [
        sqrt-of-n (Math/sqrt n)
        sqrt-of-n (int sqrt-of-n)
        ]
    (= n (* sqrt-of-n sqrt-of-n))))

(defn- get-result-for-one [n]
  (->> n
       (get-divisors)
       (map #(* % %))
       (reduce + 0)
       ((fn[sum] (when (square? sum) [n, sum])))
       ))

(defn list-squared [m n]
  (->> (range m (inc n))
       (map get-result-for-one)
       (filter #(not (nil? %)))
       ))