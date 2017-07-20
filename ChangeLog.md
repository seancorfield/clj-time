## Changes Between 0.13.0 and 0.14.0

* Add `from-epoch`.
* Clarify `today-at` is UTC.
* Add optional `clj-time.spec` namespace (requires Clojure 1.9 Alpha 17).
* Add `clj-time.types` namespace with type-based predicates.

## Changes Between 0.12.2 and 0.13.0

* Update Joda Time to 2.9.7 (#223).

## Changes Between 0.12.1 and 0.12.2

* More reflection warnings removed (#221).

## Changes Between 0.12.0 and 0.12.1

* Updated Joda Time (to 2.9.4) and several testing dependencies as well.
* `floor` now retains timezone information (#204).
* Reflection warning removed from `with-time-at-start-of-day` (#219).

## Changes Between 0.11.0 and 0.12.0 (June 6th, 2016)

### Joda Time 2.9.3

[Joda Time](http://www.joda.org/joda-time/) has been [upgraded to `2.9.3`](http://www.joda.org/joda-time/upgradeto293.html).

### java.jdbc coercions

`java.sql.Date` and `java.sql.Time` are now coerced automatically if you `require` `clj-time.jdbc` (previously only `java.sql.Timestamp` was coerced).

### Formatters

The `formatter` function now accepts keywords and formatter objects, as well as string formats, so you can easily select a standard format (with a keyword) or provide a specific formatter object.

### Clojure 1.8 by Default

The library now depends on Clojure `1.8.0` and is tested against `1.6.0`, `1.7.0`, and `1.9.0-master-SNAPSHOT`.

### Enhancements

* `first-day-of-the-month?` and `last-day-of-the-month?` -- aliases to improve consistency (so it's `the-month` everywhere).
* `min-date` and `max-date` -- to return the minimum or maximum of two or more dates.
* `nth-day-of-the-month` -- return the Nth day of the year/month, or date/time.
* `nth-day-of-the-month?` -- return true if a given date/time is on the Nth day of its month.
* `with-time-at-start-of-day` -- return the time at the start of the day, including timezone and DST support.

### Deprecations

* `today-at-midnight` -- deprecated in favor of `with-time-at-start-of-day`.

### Bug Fixes

[Issue 185](https://github.com/clj-time/clj-time/issues/185) is fixed by explicitly tying the `:rfc822` formatter to the US locale.

The examples in the README are now automatically tested (by midje-readme) so they are more likely to be valid.

## Changes Between 0.10.0 and 0.11.0

### Joda Time 2.8

[Joda Time](http://www.joda.org/joda-time/) has been [upgraded to `2.8.2`](http://www.joda.org/joda-time/upgradeto282.html).

### Clojure 1.7 by Default

The library now depends on Clojure `1.7.0`.



## Changes Between 0.9.0 and 0.10.0

### clj-time.instant

`clj-time.instant` is a new namespace that, when loaded, makes it possible
for the Clojure reader to serialize Joda Time data types.

### Joda Time 2.7

[Joda Time](http://www.joda.org/joda-time/) has been [upgraded to `2.7`](http://www.joda.org/joda-time/upgradeto270.html).

### `equal?`

A new predicate `equal?` has been added, which can be used like `before?` and
`after?` to assert two instants represent identical points in time regardless of
differences in time zone.

Contributed by [@gws](https://github.com/gws).

### `clj-time.jdbc`

A new namespace `clj-time.jdbc` has been added which extends protocols in
clojure.java.jdbc to allow for easy coercion to and from java.sql.Timestamp
driven by `clj-time.coerce`.

Contributed by [@gws](https://github.com/gws).

## Changes Between 0.8.0 and 0.9.0

### with-default-year

`clj-time.format/with-default-year` is a new function that accepts a formatter
and returns a formatter that uses provided year by default.

Contributed by lummax.

### InTimeUnitProtocol

`clj-time.core/InTimeUnitProtocol` is a new protocol that provides convenient
functions for time unit conversion:

``` clojure
(defprotocol InTimeUnitProtocol
  "Interface for in-<time unit> functions"
  (in-millis  [this] "Return the time in milliseconds.")
  (in-seconds [this] "Return the time in seconds.")
  (in-minutes [this] "Return the time in minutes.")
  (in-hours   [this] "Return the time in hours.")
  (in-days    [this] "Return the time in days.")
  (in-weeks   [this] "Return the time in weeks")
  (in-months  [this] "Return the time in months")
  (in-years   [this] "Return the time in years"))
```

### Clojure 1.2-1.4 Support Dropped

`clj-time` now officially supports Clojure `1.5.1` and later versions.

### Joda Time 2.6

[Joda Time](http://www.joda.org/joda-time/) has been [upgraded to `2.6`](http://www.joda.org/joda-time/upgradeto260.html).
