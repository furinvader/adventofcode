(ns adventofcode.core
  (:gen-class))

(defn read-puzzle-input
  [year day puzzle]
  (try (slurp (str "resources/puzzle_inputs/year_" year
                   "/day_" day
                   "_puzzle_" puzzle
                   ".txt"))
       (catch java.io.FileNotFoundException e
         (str "No puzzle input found for year:" year " day:" day " puzzle:" puzzle))))

(defn -main
  [& args]
  (let [[year day puzzle] args]
    (println (read-puzzle-input year day puzzle))))
