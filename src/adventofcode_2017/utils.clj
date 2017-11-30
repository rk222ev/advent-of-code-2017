(ns adventofcode-2017.utils)


(defn read-input
  [day]
  (slurp (str "resources/day_" day ".txt")))
