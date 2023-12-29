(ns adventofcode.year-2023.day-3.core
  (:require [adventofcode.core :refer [create-puzzle-main]]
            [adventofcode.year-2023.day-3.puzzle-1 :as p1]
            [adventofcode.year-2023.day-3.puzzle-2 :as p2]))

(def example-input "467..114..
...*......
..35..633.
......#...
617*......
.....+.58.
..592.....
......755.
...$.*....
.664.598..")

(def -main (create-puzzle-main
            [[p1/solve-puzzle example-input]
             [p2/solve-puzzle example-input]]))
