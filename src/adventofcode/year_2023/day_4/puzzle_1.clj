(ns adventofcode.year-2023.day-4.puzzle-1
  (:require [clojure.set :as set]
            [clojure.string :as str]))

(defn split-numbers [index target]
  (update target index #(str/split % #"\s+\|\s+")))

(defn parse-numbers [index target]
  (update target index (comp
                        set
                        (fn [nums] (map #(Integer/parseInt %) nums))
                        #(str/split % #"\s+"))))

(defn parse-card [line]
  (->> line
       (re-find #"^Card\s+(\d+):\s+(.*)")
       (rest)
       (vec)
       (split-numbers 1)
       (flatten)
       (vec)
       (parse-numbers 1)
       (parse-numbers 2)
       ((fn [[id winning having]]
          {:id id
           :winning winning
           :having having}))))

(defn solve-puzzle [input]
  (->> input
       (str/split-lines)
       (map parse-card)
       (map (juxt :winning :having))
       (map (comp count #(apply set/intersection %)))
       (filter #(< 0 %))
       (map #(int (Math/pow 2 (- % 1))))
       (reduce +)))
