
module triangle
   implicit none

   interface equilateral
      module procedure equilateral_real
      module procedure equilateral_int
   end interface

   interface scalene
      module procedure scalene_real
      module procedure scalene_int
   end interface

   interface isosceles
      module procedure isosceles_real
      module procedure isosceles_int
   end interface

   real, parameter :: DELTA = 0.0000000001

contains

   logical function isEqual(n1, n2)
      real :: n1, n2
      isEqual = abs(n1 - n2) <= DELTA
   end function


   logical function isTriangle(edges)
      real, dimension(3) :: edges
      integer :: i
      isTriangle =  all(edges > 0)
      if(.not. isTriangle) then
         return
      end if
      do i = 1, size(edges)
         if(sum(edges) - edges(i) < edges(i)) then
            isTriangle = .false.
            return
         end if
      end do
      !  = abs(n1 - n2) <= DELTA
   end function

   logical function isTriangleInt(edges)
      integer, dimension(3):: edges
      isTriangleInt = isTriangle(real(edges))
   end function

   logical function equilateral_real(edges)
      real,dimension(3) :: edges
      equilateral_real = isTriangle(edges) .and. isEqual(edges(1), edges(2)) .and. isEqual(edges(2), edges(3))
   end function

   logical function equilateral_int(edges)
      integer,dimension(3) :: edges
      equilateral_int = isTriangleInt(edges) .and. (edges(1) == edges(2)) .and. (edges(2) == edges(3))
   end function

   logical function isosceles_real(edges)
      real,dimension(3) :: edges
      isosceles_real = isTriangle(edges) .and. (isEqual(edges(1), edges(2)) .or. isEqual(edges(2), edges(3)) &
                                                .or. isEqual(edges(1), edges(3)))
   end function

   logical function isosceles_int(edges)
      integer,dimension(3) :: edges
      isosceles_int = isTriangleInt(edges) .and. ((edges(1) == edges(2)) .or. (edges(2) == edges(3)) .or. (edges(1) == edges(3)))
   end function


   logical function scalene_real(edges)
      real,dimension(3) :: edges
      scalene_real = isTriangle(edges) .and. (.not. isosceles_real(edges))
   end function

   logical function scalene_int(edges)
      integer,dimension(3) :: edges
      scalene_int =  isTriangleInt(edges) .and. (.not. isosceles_int(edges))
   end function

end module
