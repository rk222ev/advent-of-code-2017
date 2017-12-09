(ns adventofcode-2017.days.06
  (:require
   [clojure.string :as str]
   [adventofcode-2017.utils :as utils]))


(def example [0 2 7 0])


(defn find-biggest-bank
  [banks]
  (loop [index 0 biggest-index nil biggest nil xs banks]
    (if (empty? xs)
      biggest-index
      (let [head (first xs)
            head-is-bigger? (or (nil? biggest) (> head biggest))
            new-biggest (if head-is-bigger? head biggest)]
        (recur
         (+ index 1)
         (if head-is-bigger? index biggest-index)
         new-biggest
         (rest xs))))))


(defn calculate-new-banks
  [banks blocks index]
  (loop [b banks bl blocks i index]
    (if (empty? bl)
      b
      (recur
       (assoc b i (+ (nth b i) (first bl)))
       (rest bl)
       (if (>= i (- (count b) 1)) 0 (+ 1 i) )))))


(defn redistribute
  [banks max]
  (let [index-with-biggest-bank (find-biggest-bank banks)
        number-of-blocks (nth banks index-with-biggest-bank)
        emptied-banks (assoc banks index-with-biggest-bank 0)
        blocks (take number-of-blocks (repeat 1))
        i (+ 1 index-with-biggest-bank)
        starting-index (if (>= i max) 0 i)]
    (calculate-new-banks emptied-banks blocks starting-index)))


(defn find-first-returning-redistribution
  [banks]
  (let [bank-count (count banks)]
    (loop [b banks coll [] cycles 1]
      (let [redistribution (redistribute b bank-count)]
        (if (some #(= % redistribution) coll)
          cycles
          (recur redistribution (conj coll redistribution) (+ 1 cycles)))))))


(def input [4 1 15 12 0 9 9 5 5 8 7 3 14 5 12 3])

(defn main
  []
  (find-first-returning-redistribution input)) ;; => 6681
