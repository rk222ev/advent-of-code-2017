(ns adventofcode-2017.utils
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]))


(defn str->int [s] (Integer/parseInt s))
(defn str->int-list [s] (vec (map str->int s)))

(defn char->int [c] (str->int (str c)))
(defn char->int-list [c] (vec (map char->int c)))



(defn read-input
  [day]
  (slurp (io/resource (str "day_" day ".txt"))))
