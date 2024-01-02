(ns adventofcode.year-2023.day-3.puzzle-2
  (:require [adventofcode.year-2023.day-3.puzzle-1 :refer [get-parts-with-adjacent-numbers]]))

(defn solve-puzzle [input]
  (->> (get-parts-with-adjacent-numbers input)
       (filter #(= "*" (:target %)))
       (filter #(= 2 (count (:adjacent %))))
       (map :adjacent)
       (map #(apply * %))
       (reduce +)))
