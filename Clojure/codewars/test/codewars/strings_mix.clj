(ns codewars.strings-mix
  (:require [clojure.test :refer :all]
            [codewars.strings-mix :refer :all]))

(deftest a-test1
  (testing "Basic tests"
    (is (= (mix "Are they here" "yes, they are here") "2:eeee/2:yy/=:hh/=:rr"))
    (is (= (mix "looping is fun but dangerous" "less dangerous than coding") "1:ooo/1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg"))
    (is (= (mix " In many languages" " there's a pair of functions") "1:aaa/1:nnn/1:gg/2:ee/2:ff/2:ii/2:oo/2:rr/2:ss/2:tt"))
    (is (= (mix "Lords of the Fallen" "gamekult") "1:ee/1:ll/1:oo"))
    (is (= (mix "codewars" "codewars") ""))
    (is (= (mix "A generation must confront the looming " "codewarrs") "1:nnnnn/1:ooooo/1:tttt/1:eee/1:gg/1:ii/1:mm/=:rr"))
    ))

