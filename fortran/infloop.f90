program infloop
	implicit none

	integer :: i

	print *, "Hello from programm beginning"
	do i = 1,10,1
		print *, "Hello from loop", i
	end do
end program