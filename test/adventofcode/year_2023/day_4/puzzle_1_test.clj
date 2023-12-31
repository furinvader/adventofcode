(ns adventofcode.year-2023.day-4.puzzle-1-test
  (:require [adventofcode.year-2023.day-4.core :refer [example-input]]
            [adventofcode.year-2023.day-4.puzzle-1 :refer [solve-puzzle]]
            [clojure.test :refer [deftest is testing]]))

(deftest solve-puzzle-test
  (testing "Solves 2023 day 4 puzzle 1"
    (is (= 13 (solve-puzzle example-input)))))
