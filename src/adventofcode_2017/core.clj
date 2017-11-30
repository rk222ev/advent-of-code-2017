(ns adventofcode-2017.core
  (:require
   [adventofcode-2017.days.one :as day-one])
  (:gen-class))

(defn -main
  [& args]
  (if (empty? args)
    (println "Choose day to run...")
    (let [choice (Integer/parseInt (first args))]
      (case choice
        1 (println (day-one/run))))))

(comment
  (-main "1")

  )
