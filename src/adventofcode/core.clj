(ns adventofcode.core
  (:gen-class))

(defn read-puzzle-input-file
  [input-file-path]
  (try (slurp input-file-path)
       (catch java.io.FileNotFoundException _
         (println "No puzzle input not found: " input-file-path))))

(defn -main []
  (println "To solve a puzzle, run an alias like `lein run y2023d1p1`"))
