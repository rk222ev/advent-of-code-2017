(ns adventofcode-2017.days.one-test
  (:require [clojure.test :refer :all]
            [adventofcode-2017.days.one :refer :all]))


(deftest a-test
  (testing "Will calculate correct sums"
    (is (= (run "1122") 3))
    (is (= (run "1111") 4))
    (is (= (run "1234") 0))
    (is (= (run "91212129") 9))))

(deftest test-real-input
  (is (= (main) 997)))


(deftest b-test
  (testing "Will calculate correct sums for part 2"
    (is (= (run2 "1212") 6))
    (is (= (run2 "1221") 0))
    (is (= (run2 "123425") 4))
    (is (= (run2 "12131415") 4))))
