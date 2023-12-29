(ns adventofcode.core
  (:gen-class))

(defn read-puzzle-input-file
  [input-file-path]
  (try (slurp input-file-path)
       (catch java.io.FileNotFoundException _
         (println "Puzzle input file not found: " input-file-path))))

(defn create-puzzle-main [solver-fns example-input]
  (fn [input-file-path & args]
    (let [args (set args)
          use-example (contains? args "-e")
          use-time (contains? args "-t")
          p1-only (contains? args "-p1")
          p2-only (contains? args "-p2")
          solver-fns (if p1-only [(get solver-fns 0)] solver-fns)
          solver-fns (if p2-only [(get solver-fns 1)] solver-fns)
          solver-fns (remove nil? solver-fns)
          puzzle-input (if use-example
                         example-input
                         (read-puzzle-input-file input-file-path))]
      (run! #(println
              (if use-time
                (time (% puzzle-input))
                (% puzzle-input)))
            solver-fns))))

(defn -main []
  (println "To solve a puzzle, run an alias like `lein y2023d1`"))
