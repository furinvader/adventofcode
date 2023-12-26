(ns adventofcode.year-2023.day-2.puzzle-1-test
  (:require [adventofcode.year-2023.day-2.puzzle-1 :refer [solve-puzzle]]
            [clojure.test :refer [deftest is testing]]))

(def puzzle-input "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green")

(deftest solve-puzzle-test
  (testing "Solves 2023 day 2 puzzle 1"
    (is (= 8 (solve-puzzle puzzle-input)))))
