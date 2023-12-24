(ns adventofcode.year-2023.day-1-test
  (:require [adventofcode.year-2023.day-1 :refer [solve-puzzle-1
                                                  solve-puzzle-2]]
            [clojure.test :refer [deftest is testing]]))

(def puzzle-1-input "1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet")

(deftest solve-year-2023-day-1-puzzle-1-test
  (testing "Combines the first and last digit of a string to two-digit number"
    (is (= 12 (solve-puzzle-1 "12")))
    (is (= 15 (solve-puzzle-1 "12345")))
    (is (= 33 (solve-puzzle-1 "3")))
    (is (= 44 (solve-puzzle-1 "abc4cdef4ghij"))))
  (testing "Solves puzzle 1"
    (is (= 142 (solve-puzzle-1 puzzle-1-input)))))

(def puzzle-2-input "two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen")

(deftest solve-year-2023-day-1-puzzle-2-test
  (testing "Combines the first and last digit, including words, of a string to two-digit number"
    (is (= 12 (solve-puzzle-2 "one7two")))
    (is (= 15 (solve-puzzle-2 "one2three4five")))
    (is (= 33 (solve-puzzle-2 "three")))
    (is (= 44 (solve-puzzle-2 "abcfourcdeffourghij")))
    (is (= 28 (solve-puzzle-2 "twonethreeight")))
    (is (= 22 (solve-puzzle-2 "abc2345twoabc")))
    (is (= 38 (solve-puzzle-2 "threeight"))))
  (testing "Solves puzzle 2"
    (is (= 281 (solve-puzzle-2 puzzle-2-input)))))