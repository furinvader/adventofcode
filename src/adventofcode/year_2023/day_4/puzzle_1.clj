(ns adventofcode.year-2023.day-4.puzzle-1
  (:require [clojure.set :as set]
            [clojure.string :as str]))

(defn split-numbers [index target]
  (update target index #(str/split % #"\s+\|\s+")))

(defn parse-numbers [index target]
  (update target index (comp
                        set
                        (fn [nums]
                          (map #(Integer/parseInt %) nums))
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
          (let [matching (set/intersection winning having)]
            {:id (Integer/parseInt id)
             :winning winning
             :having having
             :matching matching
             :matching-amount (count matching)})))))

(defn parse-cards [input]
  (map parse-card (str/split-lines input)))

(defn solve-puzzle [input]
  (->> input
       (parse-cards)
       (map :matching-amount)
       (filter #(< 0 %))
       (map #(int (Math/pow 2 (- % 1))))
       (reduce +)))
