(ns adventofcode.year-2023.day-1.puzzle-2-test
  (:require [adventofcode.year-2023.day-1.puzzle-2 :refer [solve-puzzle]]
            [clojure.test :refer [deftest is testing]]))

(def puzzle-input "two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen")

(deftest solve-puzzle-test
  (testing "Combines the first and last digit, including words, of a string to two-digit number"
    (is (= 12 (solve-puzzle "one7two")))
    (is (= 15 (solve-puzzle "one2three4five")))
    (is (= 33 (solve-puzzle "three")))
    (is (= 44 (solve-puzzle "abcfourcdeffourghij")))
    (is (= 28 (solve-puzzle "twonethreeight")))
    (is (= 22 (solve-puzzle "abc2345twoabc")))
    (is (= 38 (solve-puzzle "threeight"))))
  (testing "Solves puzzle 2"
    (is (= 281 (solve-puzzle puzzle-input)))))
