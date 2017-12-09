(ns adventofcode-2017.days.07
  (:require
   [clojure.string :as str]
   [adventofcode-2017.utils :as utils]))

(def example
  "pbga (66)
xhth (57)
ebii (61)
havc (66)
ktlj (57)
fwft (72) -> ktlj, cntj, xhth
qoyq (66)
padx (45) -> pbga, havc, qoyq
tknk (41) -> ugml, padx, fwft
jptl (61)
ugml (68) -> gyxo, ebii, jptl
gyxo (61)
cntj (57)")

(defn build-program
  [[p children]]
  {:program (-> p
                (str/split #" ")
                first)
   :children (-> children
                 (str/replace #" " "")
                 (str/split #","))})

(defn main
  []
  (let [input (->> (utils/read-input "07")
                   str/split-lines
                   (map #(str/split % #"->"))
                   (filter #(contains? % 1))
                   (map #(build-program %)))
        children (mapcat #(:children %) input)
        programs (map #(:program %) input)]
    (filter #(not (.contains children %)) programs))) ;; => uownj
