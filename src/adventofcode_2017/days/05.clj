(ns adventofcode-2017.days.05
  (:require
   [clojure.string :as str]
   [adventofcode-2017.utils :as utils]))


(def example [0 3 0 1 -3])
(def example [0 3 0 1 -2])
(def example [0 0 0 0 0 0 -6])
(def example [0 -1 0 -1 0 -1 1])

(defn calculate-new-position [n] (if (= 0 n ) 1 (+ 1 n)))

(defn do-jumps
  [xs]
  (loop [position 0
         xsn xs
         max-index (- (count xs) 1)
         steps 1]
   (let [jump (nth xsn position)
         next-index (+ position jump)]
     (if  (or (< max-index next-index)
              (> 0 next-index))
       steps
       (recur
        next-index
        (assoc xsn position (calculate-new-position jump))
        max-index (+ 1 steps))))))


(defn main []
  (let [input (vec (->> (utils/read-input "05")
                        str/split-lines
                        (map #(Integer/parseInt %))))]
    (do-jumps input)))

;; 388611
