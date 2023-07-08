module leap
   implicit none

contains

   logical function is_leap_year(year)
      integer :: year
      if (modulo(year, 400) == 0) then
         is_leap_year = .true.
      else if (modulo(year, 100) == 0)  then
         is_leap_year = .false.
      else
         is_leap_year = modulo(year , 4) == 0
      endif
   end function

end module

