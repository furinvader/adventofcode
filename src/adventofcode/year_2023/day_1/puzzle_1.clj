;; https://adventofcode.com/2023/day/1

(ns adventofcode.year-2023.day-1.puzzle-1
  (:require [clojure.string :as str]))

(defn solve-puzzle [input]
  (->> (str/split input #"\n")
       (map #(as-> % v
               (str/replace v #"\D" "")
               (str/split v #"")
               (str (first v) (last v))
               (Integer/parseInt v)))
       (reduce +)))