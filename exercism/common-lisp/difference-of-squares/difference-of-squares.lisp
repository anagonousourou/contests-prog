(defpackage :difference-of-squares
  (:use :cl)
  (:export :sum-of-squares
           :square-of-sum
           :difference))

(in-package :difference-of-squares)


(defun sum-of-squares (n)
  "Calculates the sum of squares for a given number."
(let (
  (my-num (* n (1+ n) (1+ (* n 2))) )
  (sum (/ my-num 6))
  ) sum)
)

(defun square-of-sum (n)
"Calculates the square of the sum for a given number."
(let ((sm (/ (* n (1+ n)) 2)))
(* sm sm)))

(defun difference (n)
"Finds the diff. between the square of the sum and the sum of the squares."
(- (square-of-sum n) (sum-of-squares n)))
