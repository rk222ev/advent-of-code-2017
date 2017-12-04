(ns adventofcode-2017.days.04
  (:require
   [clojure.string :as str]
   [adventofcode-2017.utils :as utils]))


(defn valid?
  [s]
  (let [original (str/split s #" ")]
    (= (count original) (count (distinct original)))))


;; (valid? "aa bb cc dd ee")
;; (not (valid? "aa bb cc dd aa"))
;; (valid? "aa bb cc dd aaa")

(defn main [] (count (filter valid? (str/split (utils/read-input "04") #"\n"))))
