(ns adventofcode.year-2023.day-1.puzzle-1-test
  (:require [adventofcode.year-2023.day-1.core :refer [example-input-1]]
            [adventofcode.year-2023.day-1.puzzle-1 :refer [solve-puzzle]]
            [clojure.test :refer [deftest is testing]]))

(deftest solve-puzzle-test
  (testing "Combines the first and last digit of a string to two-digit number"
    (is (= 12 (solve-puzzle "12")))
    (is (= 15 (solve-puzzle "12345")))
    (is (= 33 (solve-puzzle "3")))
    (is (= 44 (solve-puzzle "abc4cdef4ghij"))))
  (testing "Solves 2023 day 1 puzzle 1"
    (is (= 142 (solve-puzzle example-input-1)))))
