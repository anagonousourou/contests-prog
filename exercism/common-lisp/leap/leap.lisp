(defpackage :leap
  (:use :cl)
  (:export :leap-year-p))
(in-package :leap)

(defun leap-year-p (year)
  (cond
    ((zerop (mod year 4)) (cond
    ((zerop (mod year 100)) (zerop (mod year 400)))
    (t t)))
    (t nil)
  ))
