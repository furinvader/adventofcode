(ns adventofcode.year-2023.day-1.puzzle-2-test
  (:require [adventofcode.year-2023.day-1.core :refer [example-input-2]]
            [adventofcode.year-2023.day-1.puzzle-2 :refer [solve-puzzle]]
            [clojure.test :refer [deftest is testing]]))

(deftest solve-puzzle-test
  (testing "Combines the first and last digit, including words, of a string to two-digit number"
    (is (= 12 (solve-puzzle "one7two")))
    (is (= 15 (solve-puzzle "one2three4five")))
    (is (= 33 (solve-puzzle "three")))
    (is (= 44 (solve-puzzle "abcfourcdeffourghij")))
    (is (= 28 (solve-puzzle "twonethreeight")))
    (is (= 22 (solve-puzzle "abc2345twoabc")))
    (is (= 38 (solve-puzzle "threeight"))))
  (testing "Solves 2023 day 1 puzzle 2"
    (is (= 281 (solve-puzzle example-input-2)))))
