(ns clj-time.periodic-test
  (:require [clojure.test :refer :all]
            [clj-time.core :refer [date-time hours months]]
            [clj-time.periodic :refer :all]))

(deftest test-periodic-sequence
  (let [d0 (date-time 2012 3 3 20 0)
        d1 (date-time 2012 3 3 21 0)
        d2 (date-time 2012 3 3 22 0)
        d3 (date-time 2012 3 3 23 0)
        d4 (date-time 2012 3 4 0 0)
        d5 (date-time 2012 3 4 1 0)
        d6 (date-time 2012 3 4 2 0)
        uds (periodic-seq d0 (hours 1))]
    (are [a b] (= a b)
         d0 (first uds)
         d1 (second uds)
         d2 (nth uds 2)
         d3 (nth uds 3)
         d4 (nth uds 4)
         d5 (nth uds 5)
         d6 (nth uds 6))))

(deftest test-periodic-sequence-2
  (let [d0 (date-time 2014 1 31)
        d1 (date-time 2014 2 28)
        d2 (date-time 2014 3 31)
        d3 (date-time 2014 4 30)
        uds (periodic-seq d0 (months 1))]
    (are [a b] (= a b)
         d0 (first uds)
         d1 (second uds)
         d2 (nth uds 2)
         d3 (nth uds 3))))

(deftest test-limited-periodic-sequence
  (let [d0 (date-time 2014 1 31)
        d1 (date-time 2014 2 28)
        d2 (date-time 2014 3 31)
        d3 (date-time 2014 4 30)
        uds (periodic-seq d0 d3 (months 1))]
    (are [a b] (= a b)
         d0 (first uds)
         d1 (second uds)
         d2 (nth uds 2))
    (are [i] (thrown? IndexOutOfBoundsException (nth uds i)) 3)))

