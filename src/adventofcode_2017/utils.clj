(ns adventofcode-2017.utils
  (:require
   [clojure.string :as str]))


(defn str->int [s] (Integer/parseInt s))
(defn str->int-list [s] (vec (map str->int s)))

(defn char->int [c] (str->int (str c)))
(defn char->int-list [c] (vec (map char->int c)))



(defn read-input
  [day]
   (slurp (str "resources/day_" day ".txt")))
