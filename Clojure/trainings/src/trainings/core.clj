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

(defn project-euler1
  "Multiples of 3 or 5
   If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
   Find the sum of all the multiples of 3 or 5 below 1000."
  []
  (reduce + (filter (fn [n] (or (zero? (mod n 5) ) (zero? (mod n 3)))) (range 1000))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (project-euler1))
)
