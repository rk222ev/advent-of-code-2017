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


(defn run
  [s]
  (let [xs (utils/char->int-list s)]
    (:sum (reduce calculate {:sum 0 :last (last xs)} xs))))


(defn main [] (run (str/trim-newline(utils/read-input "one"))))
