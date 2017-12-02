(ns adventofcode-2017.days.two
  (:require
   [clojure.string :as str]
   [adventofcode-2017.utils :as utils]))


(defn- split-each-on-tab [xs] (vec (map (fn [x] (str/split x #"\t")) xs)))
(defn- ->ints [xs] (map (fn [x] (utils/str->int-list x)) xs))


(defn run
  [list-of-rows checksum]
  (->>
   list-of-rows
   (map checksum)
   (apply +)))


(defn per-value
  [n xs]
  (cond
    (empty? xs) nil
    (= 0 (mod n (first xs))) (/ n (first xs))
    (= 0 (mod (first xs) n)) (/ (first xs) n)
    :default (per-value n (rest xs))))


(defn get-first-evenly-div
  [n xs]
  (if (empty? xs)
    nil
    (let [v (per-value n xs)]
      (if v v (get-first-evenly-div (first xs) (rest xs))))))


(defn checksum-part-1 [xs] (- (apply max xs) (apply min xs)))
(defn checksum-part-2 [xs] (get-first-evenly-div (first xs) (rest xs)))


(defn main
  []
  (let [input (->
               (utils/read-input "two")
               (str/split #"\n")
               split-each-on-tab
               ->ints)]
    {:part-1 (run input checksum-part-1)
     :part-2 (run input checksum-part-2)}))
