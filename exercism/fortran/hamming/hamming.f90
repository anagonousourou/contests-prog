module hamming
   implicit none
contains

   function compute(strand1, strand2, distance)
      character(*) :: strand1, strand2
      integer :: distance
      logical :: compute
      integer :: i, len1, len2
      compute = .true.
      distance = 0
      len1 = len_trim(strand1)
      len2 = len_trim(strand2)
      if (len1 /= len2) then
         compute = .false.
         return
      end if
      do i = 1, len1
         if (strand1(i:i) /= strand2(i:i)) then
            distance = distance + 1
         end if
      end do
   end function compute
end module hamming
