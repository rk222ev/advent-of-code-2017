(ns adventofcode-2017.days.one
  (:require
   [clojure.string :as str]
   [adventofcode-2017.utils :as utils]))

(defn- new-sum
  [ahead xs sum]
  (if (= ahead (first xs))
    (+ sum ahead)
    sum))


(defn- calculate
  [look-ahead sum xs]
  (if (= look-ahead (count xs))
    sum
    (let [ahead (nth xs look-ahead)
          new-sum (new-sum ahead xs sum)]
      (calculate look-ahead new-sum (rest xs)))))


(defn run [xs look-ahead] (calculate look-ahead 0 (concat xs (take look-ahead xs))))


(defn main
  []
  (let [input (-> (utils/read-input "one")
               str/trim-newline
               utils/char->int-list)]
    {:part-1 (run input 1)
     :part-2 (run input (/ (count input) 2))}))
