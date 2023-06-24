(defpackage :isogram
  (:use :cl)
  (:export :isogram-p))

(in-package :isogram)


  (defun isogram-p (sentence-str)
"Checks if a string is an isogram."
(let ((letters-list (remove-if-not #'alpha-char-p ; filter out non-letters
(string-downcase sentence-str)))) ; convert to lowercase
(= (length letters-list) (length (remove-duplicates letters-list))))) ; compare lengths of original and deduplicated lists
