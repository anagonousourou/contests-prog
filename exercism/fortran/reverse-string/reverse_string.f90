module reverse_string
   implicit none
contains

   function reverse(string)
      character(len=*), intent(in) :: string
      character(len=len(string)) :: reverse
      integer :: i, n

      n = len(string)
      do i = 1, n
         reverse(n-i+1:n-i+1) = string(i:i)
      end do
   end function reverse
end module reverse_string

