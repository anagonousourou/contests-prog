(ns codewars.core-test
  (:require [clojure.test :refer :all]
            [codewars.digital-root :refer :all]))


(deftest digital-root-example-test
  (is (= (digital-root 16) 7))
  (is (= (digital-root 456) 6)))