(defpackage :hamming
  (:use :cl)
  (:export :distance))

(in-package :hamming)


(defun string-to-list (s)
(assert (stringp s) (s) "~s is not a string")
(coerce s 'list)) ; coerce the string into a list of characters


(defun distance (strand1 strand2) ; <- arglist goes here
(if (/= (length strand1) (length strand2)) nil ; check if the lengths are equal
(count-if #'not (mapcar #'CHAR= (string-to-list strand1) (string-to-list strand2))))) ; count how many are different