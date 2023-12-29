;; https://adventofcode.com/2023/day/3

(ns adventofcode.year-2023.day-3.puzzle-1
  (:require [clojure.set :as set]
            [clojure.string :as str]))

(defn parse-positions [pattern input]
  (as-> input i
    (str/split-lines i)
    (map-indexed (fn [index line]
                   (as-> (re-seq pattern line) l
                     (map rest l)
                     (reduce (fn [result [gap target]]
                               (let [prev (last result)
                                     offset (if prev 1 0)
                                     prev-x (last (:x prev '(0)))
                                     start-x (+ prev-x (count gap) offset)
                                     end-x (+ start-x (count target))]
                                 (conj result
                                       {:target target
                                        :x (vec (range start-x end-x))
                                        :y [index]})))
                             [] l)))
                 i)
    (flatten i)))

(defn parse-part-numbers [input]
  (->> input
       (parse-positions #"(.*?)(\d+)")
       (map #(assoc % :value (Integer/parseInt (:target %))))
       (map #(update % :x set))
       (map #(update % :y set))))

(defn parse-parts [input]
  (->> input
       (parse-positions #"(.*?)([^\.0-9])")
       (map #(let [[x] (:x %)
                   [y] (:y %)]
               (-> %
                   (assoc :x [(- x 1) x (+ x 1)])
                   (assoc :y [(- y 1) y (+ y 1)]))))
       (map #(update % :x set))
       (map #(update % :y set))))

(defn assign-adjacent-numbers [parts numbers]
  (as-> parts s
      (map (fn [part]
             (let [x (:x part)
                   y (:y part)
                   adjacent (filter #(and
                              (< 0 (count (set/intersection x (:x %))))
                              (< 0 (count (set/intersection y (:y %))))) numbers)]
               (assoc part :adjacent (map :value adjacent))))
           s)
      ))

(defn get-parts-with-adjacent-numbers [input]
  (let [numbers (parse-part-numbers input)
        parts (parse-parts input)]
    (assign-adjacent-numbers parts numbers)))

(defn solve-puzzle [input]
  (->> (get-parts-with-adjacent-numbers input)
      (map :adjacent)
      (flatten)
      (reduce +)))
