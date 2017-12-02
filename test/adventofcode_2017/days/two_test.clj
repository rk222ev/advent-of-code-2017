(ns adventofcode-2017.days.two-test
  (:require [clojure.test :refer :all]
            [adventofcode-2017.days.two :refer :all]))

(def v1 [5 1 9 5])
(def v2 [7 5 3])
(def v3 [2 4 6 8])


(deftest sums
  (testing "Will calculate correct sums"
    (is (= (calculate-checksum v1) 8))
    (is (= (calculate-checksum v2) 4))
    (is (= (calculate-checksum v3) 6))))


(deftest lowest
  (testing "correctly finds the lowest values"
    (is (= (find-lowest v1) 1))
    (is (= (find-lowest v2) 3))
    (is (= (find-lowest v3) 2))))


(deftest highest
  (testing "correctly finds the lowest values"
    (is (= (find-highest v1) 9))
    (is (= (find-highest v2) 7))
    (is (= (find-highest v3) 8))))


(deftest sum
  (testing "correctly calculates sums"
    (is (= (run [v1 v2 v3]) 18))))


(deftest test-real-input)
