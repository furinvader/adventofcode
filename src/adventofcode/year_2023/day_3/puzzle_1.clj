(ns adventofcode.year-2023.day-3.puzzle-1
  (:require [clojure.set :as set]
            [clojure.string :as str]))

(defn pair-with-previous
  ([f]
   (fn [rf]
     (let [prev (volatile! ::none)]
       (fn
         ([] (rf))
         ([result] (rf result))
         ([result input]
          (let [prior @prev
                next (if (= prior ::none)
                       (f [input])
                       (f [input prior]))]
            (vreset! prev next)
            (rf result next)))))))
  ([f coll] (sequence (pair-with-previous f) coll)))

(defn parse-positions [pattern lines]
  (->> lines
       (map #(re-seq pattern %1))
       (map #(map rest %))
       (map-indexed #(map (fn [[gap target]] {:gap gap :target target :y [%1]}) %2))
       (map #(pair-with-previous
              (fn [[cur prev]]
                (let [offset (if prev 1 0)
                      prev-x (last (:x prev '(0)))
                      start-x (+ prev-x (count (:gap cur)) offset)
                      end-x (+ start-x (count (:target cur)))]
                  (assoc cur :x (vec (range start-x end-x)))))
              %))
       (flatten)))

(defn parse-part-numbers [lines]
  (->> lines
       (parse-positions #"(.*?)(\d+)")
       (map #(assoc % :value (Integer/parseInt (:target %))))
       (map #(update % :x set))
       (map #(update % :y set))))

(def stretch 
  (juxt #(- % 1) identity #(+ 1 %)))

(defn parse-parts [lines]
  (->> lines
       (parse-positions #"(.*?)([^\.0-9])")
       (map #(update % :x (comp stretch first)))
       (map #(update % :y (comp stretch first)))
       (map #(update % :x set))
       (map #(update % :y set))))

(defn assign-adjacent-numbers [parts numbers]
  (let [numbers (group-by (comp first :y) numbers)]
    (map (fn [part]
           (assoc part :adjacent
                  (map :value (->> part
                                   (:y)
                                   (select-keys numbers)
                                   (vals)
                                   (flatten)
                                   (filter #(< 0 (count (set/intersection (:x part) (:x %)))))))))
         parts)))

(defn get-parts-with-adjacent-numbers [input]
  (let [lines (str/split-lines input)
        numbers (parse-part-numbers lines)
        parts (parse-parts lines)]
    (assign-adjacent-numbers parts numbers)))

(defn solve-puzzle [input]
  (->> (get-parts-with-adjacent-numbers input)
      (map :adjacent)
      (flatten)
      (reduce +)))
