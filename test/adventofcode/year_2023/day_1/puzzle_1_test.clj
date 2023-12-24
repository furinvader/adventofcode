(ns adventofcode.year-2023.day-1.puzzle-1-test
  (:require [adventofcode.year-2023.day-1.puzzle-1 :refer [solve-puzzle]]
            [clojure.test :refer [deftest is testing]]))

(def puzzle-input "1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet")

(deftest solve-puzzle-test
  (testing "Combines the first and last digit of a string to two-digit number"
    (is (= 12 (solve-puzzle "12")))
    (is (= 15 (solve-puzzle "12345")))
    (is (= 33 (solve-puzzle "3")))
    (is (= 44 (solve-puzzle "abc4cdef4ghij"))))
  (testing "Solves puzzle 1"
    (is (= 142 (solve-puzzle puzzle-input)))))
