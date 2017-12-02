(ns adventofcode-2017.days.one
  (:require
   [clojure.string :as str]
   [adventofcode-2017.utils :as utils]))


(defn- calculate
  [coll x]
  (let [old-sum (:sum coll)
        new-sum (if (= x (:last coll))
                  (+ old-sum x)
                  old-sum)]
    {:sum new-sum :last x}))


(defn- calculate2 [sum n match] (if (= n ) (+ sum n) sum))


(defn calculate2
  [look-ahead sum xs]
  (if (= look-ahead (count xs))
    sum
    (let [ahead (nth xs look-ahead)
          new-sum (if (= ahead (first xs))
                    (+ sum ahead)
                    sum)]
      (println (first xs) ahead)
      (calculate2 look-ahead new-sum (rest xs)))))


(defn run2
  [s]
  (let [xs (utils/char->int-list s)
        look-ahead (/ (count xs) 2)]
    (calculate2 look-ahead 0 (concat xs (take look-ahead xs)))))


(defn run
  [s]
  (let [xs (utils/char->int-list s)]
    (:sum (reduce calculate {:sum 0 :last (last xs)} xs))))

(defn part-1 [] (run (str/trim-newline(utils/read-input "one"))))
(defn part-2 [] (run2 (str/trim-newline(utils/read-input "one"))))
