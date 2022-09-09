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

(defn factors [n primeNumber]
  ""
  (expt n (if (= 0 (mod n primeNumber)) (inc (factors (quot n primeNumber) primeNumber)) 0))) 


(defn prime-factors [n primeList]
  ""
  (let [singlefactors (partial factors n)]
      (= n (map singlefactors primeList)))
    )



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (fizz-buzz 20)))

