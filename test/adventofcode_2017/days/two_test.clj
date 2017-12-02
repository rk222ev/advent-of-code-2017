(ns adventofcode-2017.days.two-test
  (:require [clojure.test :refer :all]
            [adventofcode-2017.days.two :refer :all]))

(def v1 [5 1 9 5])
(def v2 [7 5 3])
(def v3 [2 4 6 8])


(deftest sums
  (testing "Will calculate correct sums"
    (is (= (run [v1 v2 v3]) 18))
    (is (= (main) 41919))))
