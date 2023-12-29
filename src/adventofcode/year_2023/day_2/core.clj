(ns adventofcode.year-2023.day-2.core
  (:require [adventofcode.core :refer [create-puzzle-main]]
            [adventofcode.year-2023.day-2.puzzle-1 :as p1]
            [adventofcode.year-2023.day-2.puzzle-2 :as p2]))

(def example-input "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green")

(def -main (create-puzzle-main
            [p1/solve-puzzle p2/solve-puzzle]
            example-input))
