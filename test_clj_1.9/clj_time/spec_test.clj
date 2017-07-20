(ns clj-time.spec-test
  (:require [clojure.test :refer :all]
            [clojure.spec :as spec]
            [clojure.spec.gen :as gen]
            [clj-time.core :refer :all]
            [clj-time.types :as types]
            [clj-time.spec :as ts]))

(deftest test-spec-defs
  (is (spec/valid? ::ts/date-time (date-time 2018 8 22 7 12 58)))
  (is (not (spec/valid? ::ts/local-date-time (date-time 2018 8 22 7 12 58))))
  (is (not (spec/valid? ::ts/local-date (date-time 2018 8 22 7 12 58))))

  (is (not (spec/valid? ::ts/date-time (local-date-time 2018 8 22 7 12 58))))
  (is (spec/valid? ::ts/local-date-time (local-date-time 2018 8 22 7 12 58)))
  (is (not (spec/valid? ::ts/local-date (local-date-time 2018 8 22 7 12 58))))

  (is (not (spec/valid? ::ts/date-time (local-date 2018 8 22))))
  (is (not (spec/valid? ::ts/local-date-time (local-date 2018 8 22))))
  (is (spec/valid? ::ts/local-date (local-date 2018 8 22))))

(deftest test-generators
  (is (every? types/date-time? (gen/sample (spec/gen ::ts/date-time))))
  (is (every? types/local-date-time? (gen/sample (spec/gen ::ts/local-date-time))))
  (is (every? types/local-date? (gen/sample (spec/gen ::ts/local-date))))

  (is (every? #(and (before? % (date-time 2031 1 1))
                    (before? (date-time 2010 12 31) %))
              (gen/sample (spec/gen ::ts/date-time)))))


(deftest test-period-generators
  ; These generators are meant to be used with the ts/*period* dynamic var.
  ; See test-generator-with-custom-period
  (is (every? int? (gen/sample (spec/gen ::ts/past))))
  (is (every? int? (gen/sample (spec/gen ::ts/past-and-future))))
  (is (every? int? (gen/sample (spec/gen ::ts/future)))))

(deftest test-generator-with-custom-period
  (binding [ts/*period* #(spec/gen ::ts/past)]
    (is (every? #(and (before? % (date-time 2011 1 1))
                      (before? (date-time 2000 12 31) %))
                (gen/sample (spec/gen ::ts/date-time))))))
