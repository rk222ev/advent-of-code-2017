(ns adventofcode-2017.days.one-test
  (:require [clojure.test :refer :all]
            [adventofcode-2017.days.one :refer :all]))


(deftest a-test
  (testing "#run will return result"
    (is (= (run) "Result"))))
