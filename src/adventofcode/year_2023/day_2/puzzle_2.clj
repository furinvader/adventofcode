;; https://adventofcode.com/2023/day/2

(ns adventofcode.year-2023.day-2.puzzle-2
  (:require [adventofcode.year-2023.day-2.puzzle-1 :refer [parse-games]]))

(def xf-get-powers
  (comp (map :max)
        (map #(apply *  (vals %)))))

(defn solve-puzzle [input]
  (transduce xf-get-powers + (parse-games input)))
