(ns codewars.reverse-or-rotate-test
  (:require [clojure.test :refer :all]
            [codewars.reverse-or-rotate :refer :all]))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest a-test1
  (testing "revrot"
    (test-assert(revrot "1234" 0) "")
    (test-assert(revrot  "" 0) "")
    (test-assert(revrot "1234", 5), "")
    (test-assert(revrot "733049910872815764", 5), "330479108928157")
    ))