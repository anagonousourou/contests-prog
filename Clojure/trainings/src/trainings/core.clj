(ns trainings.core
  (:require [clojure.math.numeric-tower :as math :refer [expt]])
  (:gen-class))


(defn intern-fizz-buzz
  "Return Fizz, Buzz, FizzBuzz or the the parameter itself depending if the parameter is a 
   multiple of 3,5,15, or not"
  [i] (cond
        (= 0 (mod i 15)) "FizzBuzz"
        (= 0 (mod i 5)) "Buzz"
        (= 0 (mod i 3)) "Fizz"
        :else i))

(defn fizz-buzz [n]
  "FizzBuzz is the 'Hello World' of technical interview questions. 
   Your function should write the numbers from 1 to n with a twist; 
   instead of any multiplier of 3, you output Fizz, 
   instead of multiplers of 5 you output Buzz, and if they happen at the same time, 
   you should use FizzBuzz. The output of your function should be a mixed array of numbers 
   and strings."
  (map intern-fizz-buzz (range 1 n)))

(defn factors
  "Find how many factors of the prime number there is in the number n"
  [n primeNumber]
  (if (= 0 (mod n primeNumber)) (inc (factors (quot n primeNumber) primeNumber)) 0))

(defn factors-expt "Get the factor of the prime-number in n eg: 140 , 2 => 4 because 140 = 2^2 * 5 * 7"
  [n prime-number]
  (expt prime-number (factors n prime-number)))

(defn prime-factors [n primeList]
  "Given a positive integer and a non-empty list of prime numbers, determine if the number only consists of those prime factors. 
   For example, if the list of prime numbers is [2, 3, 5, 7], the number 140 = 2^2 * 5 * 7 
   has the right prime factors, while 26 = 2 * 13 does not."
  (let [singlefactors (partial factors-expt n)]
    (= n (reduce  * (map singlefactors primeList)))))


(defn unique?
  "We have an unsorted list of integers, and need to know if all numbers in the list are unique. 
   Without sorting the given array, return true if there are no two repeating numbers, or false otherwise.
  The integers are safe to compare (no floating point issues)."
  [numbers]
  (= (count numbers) (count (into #{} numbers))))

(defn left-rest
  ""
  [a-str]
  (if (empty? a-str) a-str (subs a-str 0 (- (count a-str) 1))))

(defn add-binary-digits
  ""
  [a b rem result]
  (let [default-zero (fn [p] (if (empty? p) "0" p)) d1 (default-zero (str (last a))) d2 (default-zero (str (last b)))]
    (cond
      ;; 1 1 1
      ;; 1 1 0
      ;; 0 0 0
      ;; 0 0 1
      ;; 0 1 1
      ;; 0 1 0
      (and (= a b "") (= rem "0")) result
      (= d1 d2 rem "1")  (add-binary-digits (left-rest a) (left-rest b) "1" (str "1" result))
      (and (= d1 d2 "1") (= rem "0")) (add-binary-digits (left-rest a) (left-rest b) "1" (str "0" result))
      (= d1 d2 rem "0")  (add-binary-digits (left-rest a) (left-rest b) "0" (str "0" result))
      (and (= d1 d2 "0") (= rem "1")) (add-binary-digits (left-rest a) (left-rest b) "0" (str "1" result))
      (and (not= d1 d2) (= rem "1")) (add-binary-digits (left-rest a) (left-rest b) "1" (str "0" result))
      (and (not= d1 d2) (= rem "0")) (add-binary-digits (left-rest a) (left-rest b) "0" (str "1" result)))))

(defn add-binary-numbers
  ""
  [a b]
  (add-binary-digits a b "0" ""))





(defn even-fibonacci-numbers
  "

Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
"
  ([] (even-fibonacci-numbers 1 2 0))
  ([a b sum]
   (let [a-even (if (even? a) a  0)]
     (if (> b 4000000) (+ sum a-even) (recur b (+ a b) (+ sum a-even))))))

(defn prime-iterator
  ([limit-integer] (prime-iterator limit-integer 2 [2]))
  ([limit-integer current-integer prime-numbers]
   (cond
     (>= current-integer limit-integer) prime-numbers
     (not-every? (fn [n] (not= (mod current-integer n) 0)) prime-numbers) (recur limit-integer (inc current-integer) prime-numbers)
     :else (recur limit-integer (inc current-integer) (conj prime-numbers current-integer)))))

(defn decompose-prime-factors
  ""
  [n-integer]
  (let [factors-of-n (partial factors n-integer)
        primes (prime-iterator (inc n-integer))]
    (zipmap primes (map factors-of-n primes))))

;;https://clojuredocs.org/clojure.core/zipmap 

(defn compare-factors
  ""
  [muliple-factors-map n-factors-map]
  (merge-with max muliple-factors-map n-factors-map) ;;https://clojure.org/guides/learn/hashed_colls
  )

(defn rebuild-from-factors
  "Using the prime factors and their exponent it return the number ie {2:2 , 5:1} -> 2^2 * 5 = 20"
  [factors-map]
  (reduce-kv (fn [init k v] (* init (expt k v))) 1 factors-map))



(defn smallest-multiple
  "
   Smallest multiple
   2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

   What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
  "
  ([] (smallest-multiple (range 2 21) {}))
  ([numbers] (smallest-multiple numbers {}))
  ([numbers multiple-factors-map]
   (cond
     (empty? numbers) (rebuild-from-factors multiple-factors-map)
     :else (smallest-multiple (rest numbers) (compare-factors multiple-factors-map (decompose-prime-factors (first numbers)))))))

(defn sum-square-difference
  "
   Project euler: Problem 6
   Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum."
  ([] (sum-square-difference 101))
  ([limit-integer] (- (expt (reduce + (range limit-integer)) 2) (reduce + (map (fn [x] (* x x)) (range limit-integer))))))

(defn penalty
  "
   Penalty Shootout Simulator
   
   "
  ([kicks-sequence] (penalty  kicks-sequence [0 0] 0))
  ([kicks-sequence results current-team]
   (let [other-team (if (= 0 current-team) 1 0)
         remaining-total-kicks (count kicks-sequence)
         current-team-remaining-kicks-count (if (even? remaining-total-kicks) (/ remaining-total-kicks 2) (inc (quot remaining-total-kicks 2)))
         other-team-remaining-kicks-count (if (even? remaining-total-kicks) (/ remaining-total-kicks 2) (quot (dec remaining-total-kicks) 2))
         current-team-max-results (+ (results current-team) current-team-remaining-kicks-count)
         other-team-max-results (+ (results other-team) other-team-remaining-kicks-count)
         should-not-continue (pos? (* (- (results current-team) other-team-max-results) (- current-team-max-results  (results other-team))))]
     (cond
       should-not-continue  results
       (empty? kicks-sequence) results
       (= \O (first kicks-sequence)) (recur (rest kicks-sequence)  (assoc results current-team (inc (results current-team))) other-team)
       (= \X (first kicks-sequence)) (recur (rest kicks-sequence) results other-team)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (time (penalty "OOXOOOOOXO")))
  (println (time (penalty "OOOOOOOOXO")))
  (println (time (penalty "OOOOOOOOOO"))))
