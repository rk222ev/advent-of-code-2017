(ns adventofcode-2017.days.one
  (:require
   [adventofcode-2017.utils :as utils]))


(defn- str->int-list
  [s]
  (vec (map #(Integer/parseInt (str %)) s)))


(defn- calculate
  [coll x]
  (let [last-val (:last coll)
        sum (:sum coll)]
    {:sum (if (= x last-val)
            (+ sum x)
            sum)
     :last x}))

(defn run
  [s]
  (let [xs (str->int-list s)]
    (:sum
     (reduce calculate
             {:sum 0
              :last (last xs)}
             xs))))

(defn main
  []
  (run (utils/read-input "one")))
