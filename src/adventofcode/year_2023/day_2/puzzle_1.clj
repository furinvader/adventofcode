;; https://adventofcode.com/2023/day/2

(ns adventofcode.year-2023.day-2.puzzle-1
  (:require [clojure.string :as str]))

(defn parse-draw [draw]
  (as-> draw d
    (str/split d #" ")
    (update d 0 #(Integer/parseInt %))
    (update d 1 keyword)
    (reverse d)
    (apply hash-map d)))

(defn parse-games [input]
  (let [matcher (re-matcher #"(?m)^Game (?<id>\d+): (?<rounds>.*?)$" input)]
    (loop [games []
           match (re-find matcher)]
      (if-not match
        games
        (recur
         (conj games
               {:id (Integer/parseInt (.group matcher "id"))
                :max (as-> (.group matcher "rounds") r
                       (str/split r #"; ")
                       (map #(map parse-draw (str/split % #", ")) r)
                       (map #(apply conj %) r)
                       (apply merge-with max r))})
         (re-find matcher))))))

(def xf-get-correct-game-ids
  (comp
   (filter #(let [max (:max %)]
              (and (>= 12 (:red max))
                   (>= 13 (:green max))
                   (>= 14 (:blue max)))))
   (map :id)))

(defn solve-puzzle [input]
  (transduce xf-get-correct-game-ids + (parse-games input)))
