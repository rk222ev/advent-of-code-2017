(ns adventofcode-2017.utils
  (:require
   [clojure.string :as str]))


(defn read-input
  [day]
  (str/trim-newline (slurp (str "resources/day_" day ".txt"))))
