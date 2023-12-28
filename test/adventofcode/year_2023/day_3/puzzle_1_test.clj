(ns adventofcode.year-2023.day-3.puzzle-1-test
  (:require [adventofcode.year-2023.day-3.puzzle-1 :refer [solve-puzzle]]
            [clojure.test :refer [deftest is testing]]))

(def puzzle-input "467..114..
...*......
..35..633.
......#...
617*......
.....+.58.
..592.....
......755.
...$.*....
.664.598..")

(deftest solve-puzzle-test
  (testing "Solves 2023 day 3 puzzle 1"
    (is (= 4361 (solve-puzzle puzzle-input)))))
