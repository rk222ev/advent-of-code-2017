(ns adventofcode-2017.days.two-test
  (:require [clojure.test :refer :all]
            [adventofcode-2017.days.two :refer :all]))


(deftest real
  (testing "Will calculate the real input correctly"
    (let [r (main)]
      (is (= (:part-1 r) 41919))
      (is (= (:part-2 r) 303)))))
