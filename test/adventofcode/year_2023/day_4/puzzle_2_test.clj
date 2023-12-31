(ns adventofcode.year-2023.day-4.puzzle-2-test
  (:require [adventofcode.year-2023.day-4.core :refer [example-input]]
            [adventofcode.year-2023.day-4.puzzle-2 :refer [solve-puzzle]]
            [clojure.test :refer [deftest is testing]]))

(deftest solve-puzzle-test
  (testing "Solves 2023 day 4 puzzle 2"
    (is (= 30 (solve-puzzle example-input)))))
