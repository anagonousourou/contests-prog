(ns codewars.observedpin
  (:require [clojure.test :refer :all]
            [codewars.observedpin :refer :all]))


(deftest get-pin-tests
  (def tests '(
               ("8" ("5" "7" "8" "9" "0"))
               ("11" ("11" "21" "41" "12" "22" "42" "14" "24" "44"))
               ("369" ("236" "238" "239" "256" "258" "259" "266" "268" "269" "296" "298" "299" "336" "338" "339" "356" "358" "359" "366" "368" "369" "396" "398" "399" "636" "638" "639" "656" "658" "659" "666" "668" "669" "696" "698" "699"))))
  (loop [x tests]
    (is (= (sort (get-pins (first (first x)))) (sort (last (first x)))))
    (if (> (count x) 1) (recur (rest x)))))