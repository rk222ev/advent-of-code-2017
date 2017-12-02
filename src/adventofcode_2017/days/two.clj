(ns adventofcode-2017.days.two
  (:require
   [clojure.string :as str]
   [adventofcode-2017.utils :as utils]))


(defn split-each-on-tabs [xs] (vec (map (fn [x] (str/split x #"\t")) xs)))
(defn ->ints [xs] (map (fn [x] (utils/str->int-list x)) xs))


(defn run
  []
  )


(defn main [] (run (->
                    (utils/read-input "two")
                    (str/split #"\n")
                    (split-each-on-tabs)
                    ->ints
                    )))
