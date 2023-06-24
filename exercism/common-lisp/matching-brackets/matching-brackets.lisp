(defpackage :matching-brackets
  (:use :cl)
  (:export :pairedp))

(in-package :matching-brackets)

(defun pairedp (value))


(defun pairedp (brackets)
"Checks if a string of brackets is properly paired."
(let ((opening-brackets '(#(#{#[))
(closing-brackets '(#)#}#]))
(matching-brackets '((#(#)) (#{#}) (#[#])))
(brackets-stack nil))
(loop for elt across brackets
do (cond
((member elt opening-brackets) ; if elt is an opening bracket
(push (cdr (assoc elt matching-brackets)) brackets-stack)) ; push the matching closing bracket to the stack
((and (member elt closing-brackets) ; if elt is a closing bracket
brackets-stack ; and the stack is not empty
(eql elt (car brackets-stack))) ; and elt matches the top of the stack
(pop brackets-stack)) ; pop the top of the stack
((and (member elt closing-brackets) ; if elt is a closing bracket
(or (null brackets-stack) ; and the stack is empty
(not (eql elt (car brackets-stack))))) ; or elt does not match the top of the stack
(return-from pairedp nil)))) ; return false and exit the loop
(null brackets-stack))) ; return true if the stack is empty, false otherwise
