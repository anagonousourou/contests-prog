(ns codewars.maximum-subarray-sum
  (:require [clojure.test :refer :all]
            [codewars.maximum-subarray-sum :refer :all]))

(deftest simple
  (is (= (max-sequence  [-2, 1, -3, 4, -1, 2, 1, -5, 4]) 6)))
