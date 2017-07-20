(ns clj-time.jdbc-test
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.test :refer :all]
            [clj-time.jdbc]))

(deftest test-extends-IResultSetReadColumn
  (is (extends? jdbc/IResultSetReadColumn java.sql.Timestamp))
  (is (extends? jdbc/IResultSetReadColumn java.sql.Date))
  (is (extends? jdbc/IResultSetReadColumn java.sql.Time)))

(deftest test-extends-ISQLValue
  (is (extends? jdbc/ISQLValue org.joda.time.DateTime)))
