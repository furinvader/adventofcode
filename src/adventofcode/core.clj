(ns adventofcode.core
  (:gen-class)
  (:require [adventofcode.year-2023.day-1.puzzle-1 :as y2023d1p1]
            [adventofcode.year-2023.day-1.puzzle-2 :as y2023d1p2]))

(defn read-puzzle-input
  [year day]
  (try (slurp (str "resources/puzzle_inputs/year_" year
                   "/day_" day
                   ".txt"))
       (catch java.io.FileNotFoundException _
         (println "No puzzle input found for year:" year " day:" day))))

(def solved-puzzles {"2023" {"1" {"1" y2023d1p1/solve-puzzle
                                  "2" y2023d1p2/solve-puzzle}}})

(defn -main
  [& args]
  (let [[year day puzzle] args
        puzzle-input (read-puzzle-input year day)
        puzzle-solver (get-in solved-puzzles [year day puzzle])]
    (println (puzzle-solver puzzle-input))))
