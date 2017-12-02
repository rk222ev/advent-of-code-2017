(ns adventofcode-2017.days.two
  (:require
   [clojure.string :as str]
   [adventofcode-2017.utils :as utils]))


(defn- find-product-of-first-mod-0
  [x xs]
  (when xs
    (if-let [found-value (loop [n x ns xs]
                           (let [f (first ns)]
                             (cond
                               (empty? ns) nil
                               (= 0 (mod n f)) (/ n f)
                               (= 0 (mod f n)) (/ f n)
                               :default (recur n (rest ns)))))]
      found-value
      (find-product-of-first-mod-0 (first xs) (rest xs)))))


(defn- split-each-on-tab [xs] (vec (map (fn [x] (str/split x #"\t")) xs)))
(defn- ->ints [xs] (map utils/str->int-list xs))
(defn- checksum-part-1 [xs] (- (apply max xs) (apply min xs)))
(defn- checksum-part-2 [xs] (find-product-of-first-mod-0 (first xs) (rest xs)))



(defn run
  [list-of-rows checksum]
  (->>
   list-of-rows
   (map checksum)
   (apply +)))


(defn main
  []
  (let [input (->
               (utils/read-input "two")
               (str/split #"\n")
               split-each-on-tab
               ->ints)]
    {:part-1 (run input checksum-part-1)
     :part-2 (run input checksum-part-2)}))
