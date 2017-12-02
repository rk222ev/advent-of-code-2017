(ns adventofcode-2017.days.one-test
  (:require [clojure.test :refer :all]
            [adventofcode-2017.days.one :refer :all]))


(deftest a-test
  (testing "Will calculate correct sums"
    (is (= (run [1 1 2 2] 1) 3))
    (is (= (run [1 1 1 1] 1) 4))
    (is (= (run [1 2 3 4] 1) 0))
    (is (= (run [9 1 2 1 2 1 2 9] 1) 9))))


(deftest b-test
  (testing "Will calculate correct sums for part 2"
    (is (= (run [1 2 1 2] 2) 6))
    (is (= (run [1 2 2 1] 2) 0))
    (is (= (run [1 2 3 4 2 2] 3) 4))
    (is (= (run [1 2 1 3 1 4 1 5] 4) 4))))


(deftest real-input
  (testing "Will calculate correctly using the real input"
    (is (= (main)
           {:part-1 997
            :part-2 1358}))))
