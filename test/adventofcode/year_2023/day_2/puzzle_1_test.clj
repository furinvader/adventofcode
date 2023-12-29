(ns adventofcode.year-2023.day-2.puzzle-1-test
  (:require [adventofcode.year-2023.day-2.core :refer [example-input]]
            [adventofcode.year-2023.day-2.puzzle-1 :refer [solve-puzzle]]
            [clojure.test :refer [deftest is testing]]))

(deftest solve-puzzle-test
  (testing "Solves 2023 day 2 puzzle 1"
    (is (= 8 (solve-puzzle example-input)))))
