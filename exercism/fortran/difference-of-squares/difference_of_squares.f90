module difference_of_squares
  implicit none
contains

  integer function difference(n)
    integer :: n
    difference =  square_of_sum(n)  -  sum_of_squares(n)
  end function difference

  integer function square_of_sum(n)
    integer :: n
    square_of_sum = ((1 + n) * n / 2) ** 2 
  end function

  integer function sum_of_squares(n)
    integer :: n
    sum_of_squares = ((n * (n + 1) * (2 * n + 1)) / 6)
  end function

end module difference_of_squares
