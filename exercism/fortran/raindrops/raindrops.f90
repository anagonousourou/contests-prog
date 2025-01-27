module raindrops
   implicit none
contains

   function convert(i)
      integer :: i
      character(20) :: convert
      convert = ' '
      if(mod(i, 3) == 0) then
         convert = trim(convert) // 'Pling'
      endif
      if(mod(i, 5) == 0) then
         convert = trim(convert) // 'Plang'
      endif
      if(mod(i, 7) == 0) then
         convert = trim(convert) // 'Plong'
      endif

      if(len_trim(convert) == 0) then
         write(convert, '(i10)' )  i
         convert = adjustl(convert)
      endif
   end function convert

end module raindrops

