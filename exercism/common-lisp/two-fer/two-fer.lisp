(defpackage :two-fer
  (:use :cl)
  (:export :twofer))
(in-package :two-fer)


(defun twofer (name)
(if (null name) "One for you, one for me." (format nil "One for ~A, one for me." name)))
