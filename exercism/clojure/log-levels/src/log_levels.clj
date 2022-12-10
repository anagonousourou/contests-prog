(ns log-levels
  (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (cond 
    (.startsWith s "[ERROR]:") (.strip (.substring s (count "[ERROR]:")))
    (.startsWith s "[WARNING]:") (.strip (.substring s (count "[WARNING]:")))
    (.startsWith s "[INFO]:") (.strip (.substring s (count "[INFO]:")))
    )
  )

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
    (cond
      (.startsWith s "[ERROR]:") "error"
      (.startsWith s "[WARNING]:") "warning"
      (.startsWith s "[INFO]:") "info")
  )

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (str (message s) " (" (log-level s) ")")
  )
