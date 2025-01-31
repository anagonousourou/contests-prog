
module collatz_conjecture
   implicit none
contains

   integer function steps(i)
      integer :: i, n
      n = i
      steps = 0
      if (n <= 0) then
        steps = -1
        return
      end if
      
      do while (n /= 1)
         if (mod(n, 2) == 0) then
            n = n / 2
         else
            n = 3 * n + 1
         end if
         steps = steps + 1
      end do
   end function

end module
