(defproject adventofcode "0.1.0-SNAPSHOT"
  :description "Advent of Code with Clojure"
  :url "https://adventofcode.com/"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/math.numeric-tower "0.0.5"]]
  :main ^:skip-aot adventofcode.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :aliases {"y2023d1" ["run" "-m" "adventofcode.year-2023.day-1.core"
                       "resources/puzzle_inputs/y2023_d1.txt"]
            "y2023d2" ["run" "-m" "adventofcode.year-2023.day-2.core"
                       "resources/puzzle_inputs/y2023_d2.txt"]
            "y2023d3" ["run" "-m" "adventofcode.year-2023.day-3.core"
                       "resources/puzzle_inputs/y2023_d3.txt"]
            "y2023d4" ["run" "-m" "adventofcode.year-2023.day-4.core"
                       "resources/puzzle_inputs/y2023_d4.txt"]
            "y2023d5" ["run" "-m" "adventofcode.year-2023.day-5.core"
                       "resources/puzzle_inputs/y2023_d5.txt"]})
