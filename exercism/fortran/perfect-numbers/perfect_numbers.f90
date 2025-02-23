
module perfect_numbers
  implicit none

contains

  integer function divisors_sum(n)
    integer :: i, n
    divisors_sum = 0
    do i = 1, n / 2
      if(mod(n, i) == 0) then
        divisors_sum = divisors_sum + i
      end if
    end do
  end function

  character(len=9) function classify(num)
    integer, intent(in) :: num
    integer :: s
    

    if ( num <= 0) then
      classify = "ERROR"
      return
    end if

    s = divisors_sum(num)
    if (s == num) then
      classify = "perfect"
    else if (s < num) then
      classify = "deficient"
    else
      classify = "abundant" 
    end if
  end function

end module
