(ns codewars.core-test
  (:require [clojure.test :refer :all]
            [codewars.digital-root :refer :all]
            [codewars.core :refer :all]
            ))


(deftest digital-root-example-test
  (is (= (digital-root 16) 7))
  (is (= (digital-root 456) 6)))

(defn tester [a b exp]
  (testing (str "(get-sum " a " " b ")")
    (is (= (get-sum a b) exp))))

(deftest basic-tests
  (tester 5 -1 14)
  (tester 505 4 127759)
  (tester 321 123 44178)
  (tester -50 0 -1275)
  (tester -1 -5 -15)
  (tester -5 -5 -5)
  (tester -505 4 -127755)
  (tester -321 123 -44055)
  (tester 0 0 0)
  (tester -5 -1 -15)
  (tester 5 1 15)
  (tester -17 -17 -17)
  (tester 17 17 17))

(deftest basic-tests
  (is (= (reverse-words "hello world!")                , "world! hello"))
  (is (= (reverse-words "yoda doesn't speak like this"), "this like speak doesn't yoda"))
  (is (= (reverse-words "foobar")                      , "foobar"))
  (is (= (reverse-words "kata editor")                 , "editor kata"))
  (is (= (reverse-words "row row row your boat")       , "boat your row row row")))


(deftest seven-wonders-science-test
  (is (= (seven-wonders-science 1 1 1) 10))
  (is (= (seven-wonders-science 2 1 1) 13))
  (is (= (seven-wonders-science 4 2 2) 38)))


(deftest Testing...
  (is (= (disemvowel "This website is for losers LOL!") "Ths wbst s fr lsrs LL!"))
  )

(defn test-assert [act exp]
  (is (= act exp)))

(deftest a-test1
  (testing "nb-year"
    (test-assert(nb-year 1500, 5, 100, 5000), 15)
    (test-assert(nb-year 1500000, 2.5, 10000, 2000000), 10)
    (test-assert(nb-year 1500000, 0.25, 1000, 2000000), 94)
    ))

(deftest a-test1
  (testing "find-even-index"
    (println "Fixed Tests find-even-index")
    (test-assert(find-even-index [1,2,3,4,3,2,1]), 3); 3
    (test-assert(find-even-index [1,100,50,-51,1,1]), 1); 1
    (test-assert(find-even-index [1,2,3,4,5,6]), -1); -1
    (test-assert(find-even-index [20,10,30,10,10,15,35]), 3); 3
    ))

(deftest basic-tests
  (is (= (find_shortest "bitcoin take over the world maybe who knows perhaps") 3))
  (is (= (find_shortest "turns out random test cases are easier than writing out basic ones") 3))
  (is (= (find_shortest "lets talk about javascript the best language") 3))
  (is (= (find_shortest "i want to travel the world writing code one day") 1))
  (is (= (find_shortest "Lets all go on holiday somewhere very cold") 2))
  )

(deftest Tests
  (is (= (human-readable      0) "00:00:00"))
  (is (= (human-readable     59) "00:00:59"))
  (is (= (human-readable     60) "00:01:00"))
  (is (= (human-readable     90) "00:01:30"))
  (is (= (human-readable  86399) "23:59:59"))
  (is (= (human-readable 359999) "99:59:59")))

(deftest get-prime-numbers-tests
  (is (= (get-prime-numbers-less-than      0) []))
  (is (= (get-prime-numbers-less-than     3) [2]))
  (is (= (get-prime-numbers-less-than     20) [2 3 5 7 11 13 17 19])))


(deftest find-prime-factors-tests
  (is (= (find-prime-factors [12 15]) [2 3 5]))
  (is (= (find-prime-factors [15, 30, -45]) [2 3 5]))
  (is (= (find-prime-factors [2 3 5]) [2 3 5]))
  )

(deftest sum-of-divided-test
  (testing "Sum of divided"
    (is (= (sum-of-divided [12, 15]) [ [2 12] [3 27] [5 15] ] ))))


(deftest get-pin-tests
  (def tests '(
               ("8" ("5" "7" "8" "9" "0"))
               ("11" ("11" "21" "41" "12" "22" "42" "14" "24" "44"))
               ("369" ("236" "238" "239" "256" "258" "259" "266" "268" "269" "296" "298" "299" "336" "338" "339" "356" "358" "359" "366" "368" "369" "396" "398" "399" "636" "638" "639" "656" "658" "659" "666" "668" "669" "696" "698" "699"))))
  (loop [x tests]
    (is (= (sort (get-pins (first (first x)))) (sort (last (first x)))))
    (if (> (count x) 1) (recur (rest x)))))
