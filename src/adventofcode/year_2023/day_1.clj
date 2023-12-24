;; https://adventofcode.com/2023/day/1

(ns adventofcode.year-2023.day-1
  (:require [clojure.string :as str]))

(defn solve-puzzle-1 [input]
  (->> (str/split input #"\n")
       (map #(as-> % v
               (str/replace v #"\D" "")
               (str/split v #"")
               (str (first v) (last v))
               (Integer/parseInt v)))
       (reduce +)))

(def digit-word
  {"one" "1"
   "two" "2"
   "three" "3"
   "four" "4"
   "five" "5"
   "six" "6"
   "seven" "7"
   "eight" "8"
   "nine" "9"})

(def word-group (str/join "|" (keys digit-word)))

(defn replace-first-word [input-line]
  (str/replace 
     input-line
     (re-pattern (str "^\\D*?(" word-group ")"))
     #(str (get digit-word (get % 1)) (get % 0) )))

(defn replace-last-word [input-line]
  (str/replace 
     input-line
     (re-pattern (str ".*(" word-group ")\\D*?$"))
     #(str (get % 0) (get digit-word (get % 1)))))

(defn solve-puzzle-2 [input] 
  (->> (str/split input #"\n")
         (map #(->	%
                   (replace-first-word)
                   (replace-last-word)))
         (str/join "\n")
         (solve-puzzle-1)))
