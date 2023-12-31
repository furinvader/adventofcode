(ns adventofcode.year-2023.day-4.puzzle-2
  (:require [adventofcode.year-2023.day-4.puzzle-1 :refer [parse-cards]]))


(defn calc-card-amount [matches]
  (loop [matches (map #(vector % 1) matches)
         cards 0]
    (let [current (first matches)]
      (if-not current
        cards
        (let [[match-amount card-amount] current]
          (recur (map-indexed
                  (fn [index match]
                    (if (> match-amount index)
                      (update match 1 (partial + card-amount))
                      match))
                  (rest matches))
                 (+ cards card-amount)))))))

(defn solve-puzzle [input]
  (->> input
       (parse-cards)
       (map :matching-amount)
       (calc-card-amount)))