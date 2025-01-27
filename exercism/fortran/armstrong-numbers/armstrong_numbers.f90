
module armstrong_numbers
   implicit none
contains

   logical function isArmstrongNumber(i)
      integer, intent(in) :: i
      integer :: n, nbDigits, armstrongSum
      character(12) :: nstr

      n = i
      armstrongSum = 0
      write(nstr, '(i10)' )  n
      nstr = adjustl(nstr)
      nbDigits = len_trim(nstr)

      do while (n /= 0)
         armstrongSum = armstrongSum + (mod(n, 10) ** nbDigits)
         n = n / 10
      enddo
      isArmstrongNumber = armstrongSum == i
   end function

end module
