(ns adventofcode-2017.days.two
  (:require
   [clojure.string :as str]
   [adventofcode-2017.utils :as utils]))


(defn- split-each-on-tab [xs] (vec (map (fn [x] (str/split x #"\t")) xs)))
(defn- ->ints [xs] (map (fn [x] (utils/str->int-list x)) xs))


(defn run
  [list-of-rows]
  (->>
   list-of-rows
   (map (fn [xs] (- (apply max xs) (apply min xs))))
   (apply +)))


(defn main
  []
  (->
   (utils/read-input "two")
   (str/split #"\n")
   split-each-on-tab
   ->ints
   run))
