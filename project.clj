(defproject adventofcode "0.1.0-SNAPSHOT"
  :description "Advent of Code with Clojure"
  :url "https://adventofcode.com/"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :main ^:skip-aot adventofcode.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :aliases {"y2023d1p1" ["run" "-m" "adventofcode.year-2023.day-1.puzzle-1"
                         "resources/puzzle_inputs/y2023_d1.txt"]
            "y2023d1p2" ["run" "-m" "adventofcode.year-2023.day-1.puzzle-2"
                         "resources/puzzle_inputs/y2023_d1.txt"]})
