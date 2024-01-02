(ns adventofcode.year-2023.day-5.puzzle-1
  (:require [clojure.string :as str]))

(defn parse-numbers [n-str]
  (mapv #(Long/parseLong %) (str/split n-str #"\s+")))

(defn parse-groups [g-str]
  (mapv parse-numbers (str/split-lines g-str)))

(defn create-range [[destination source range]]
  {:source-start source
   :source-end (+ source range)
   :destination destination})

(defn create-ranges [v-ranges]
  (mapv create-range v-ranges))

(defn parse-almanac [str-maps]
  (->> (str/split str-maps #"(?m)^\D+")
       (rest)
       (mapv parse-groups)
       ((fn [nums]
          {:seeds (vec (flatten (first nums)))
           :maps (mapv create-ranges (rest nums))}))))

(defn find-destination [source vmap]
  (->> vmap
       (filter #(and (>= source (:source-start %))
                     (<= source (:source-end %))))
       (first)
       (#(if-not %
           source
           (+ (:destination %) (- source (:source-start %)))))))

(defn find-seed-location [seed maps]
  (loop [source seed
         maps maps]
    (let [current-map (first maps)]
      (if-not current-map
        source
        (recur
         (find-destination source current-map)
         (vec (rest maps)))))))

(defn solve-puzzle [input]
  (let [almanac (parse-almanac input)
        seeds (:seeds almanac)
        maps (:maps almanac)
        locations (map #(find-seed-location % maps) seeds)]
    (apply min locations)))
