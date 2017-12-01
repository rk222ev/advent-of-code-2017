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
