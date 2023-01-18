(ns codewars.encode-dups-test
  (:require [clojure.test :refer :all]
            [codewars.core :refer :all])
  )

(defn dotest [text expected]
  (is (= (encode-dups text) expected)))

(deftest sample
  (testing "basic"
    (dotest "din" "(((")
    (dotest "recede" "()()()")
    (dotest "(( @" "))((")
    (dotest "ABC" "(((")
    (dotest "AaBbC" "))))(")
    )
  (testing "ignore-case" (dotest "Success" ")())())"))
  )
