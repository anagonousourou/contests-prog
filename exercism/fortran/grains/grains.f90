
module grains

   implicit none

contains

   double precision function square(n)
      integer :: n
      if(n >= 1 .and. n <= 64) then
         square = 2d0 ** (n - 1)
      else
         square = -1d0
      end if
   end function

   double precision function total()
      total = (2.d0 ** 64) - 1
   end function

end module
