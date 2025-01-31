program myfactorial
	implicit none
	
	integer :: n , answer, i
	answer = 1
	print *, "Enter a positive integer n"
	read *, n

	do i = 1,n
		answer = answer * i
	end do
	print *, "The factorial of ", n, "is ", answer
	
end program