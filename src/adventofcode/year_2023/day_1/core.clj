(ns adventofcode.year-2023.day-1.core
  (:require [adventofcode.core :refer [create-puzzle-main]]
            [adventofcode.year-2023.day-1.puzzle-1 :as p1]
            [adventofcode.year-2023.day-1.puzzle-2 :as p2]))

(def example-input-1 "1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet")

(def example-input-2 "two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen")

(def -main (create-puzzle-main
            [[p1/solve-puzzle example-input-1]
             [p2/solve-puzzle example-input-2]])) 
