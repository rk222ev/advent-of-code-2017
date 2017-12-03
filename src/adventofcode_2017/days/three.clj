(ns adventofcode-2017.days.three
  (:require
   [clojure.string :as str]
   [adventofcode-2017.utils :as utils]))


(defn find-row-coord
  [n current-layer row-size]
  (second
   (first
    (filter
     #(= (first %) n)
     (map
      vector
      current-layer
      (drop 1
            (cycle
             (map #(Math/abs %)
                  (map #(.intValue %)
                       (range (- (Math/floor (/ row-size  2)))
                              (- (/ row-size 2) 1)))))))))))

(defn walk-to-zero
  [n layer row-size]
  (let [min (-  (* row-size 4) 5)
        max (* row-size row-size)
        current-layer (range (- max min) (+ 1 max))]
    (reduce + [layer (find-row-coord n current-layer row-size)])))


(defn find-layer-for
  ([n]
   (find-layer-for n 0 1))
  ([n layer row-size]
   (let [layer-max (* row-size row-size)]
     (if (> n layer-max)
       (find-layer-for n (+ layer 1) (+ row-size 2))
       (walk-to-zero n layer row-size)))))


(defn run
  [n]
   (find-layer-for 289326))

;; Well... That was awful...

(defn main
  []
  (let [input 289326]
    {:part-1 (run input)
     :part-2 nil}))
