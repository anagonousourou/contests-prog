(ns codewars.multiples-of-3or5-test
  (:require [clojure.test :refer :all]
            [codewars.multiples-of-3or5 :refer [solution]]))

(deftest test-multiples-of-3-and-5
  (is (= 23 (solution 10))))