
module allergies
   implicit none
   character(len = 12), dimension(8), parameter :: allergens = [character(len=12) :: "eggs", "peanuts", "shellfish", &
      "strawberries",  "tomatoes", "chocolate","pollen", "cats"]
contains


   function keyByName(allergen)
      character(*) :: allergen
      integer :: keyByName
      select case(allergen)
       case ("eggs")
         keyByName = 1
       case ("peanuts")
         keyByName = 2
       case ("shellfish")
         keyByName = 4
       case ("strawberries")
         keyByName = 8
       case ("tomatoes")
         keyByName = 16
       case ("chocolate")
         keyByName = 32
       case ("pollen")
         keyByName = 64
       case ("cats")
         keyByName = 128
      end select
   end function

   logical function allergicTo(allergy_str, allergy_key)
      character(len=*), intent(in) :: allergy_str
      integer, intent(in) :: allergy_key
      if(allergy_key == 0) then
         allergicTo = .false.
      else
         allergicTo = (iand(allergy_key, keyByName(allergy_str) ) == keyByName(allergy_str))
      end if

   end function


   function allergicList(allergy_key)
      integer, intent(in) :: allergy_key
      character(len=100) :: allergicList
      integer :: i
      allergicList = ''

      do i = 1, size(allergens)
         if (allergicTo(allergens(i), allergy_key)) then
            if( len_trim(allergicList) == 0) then
               allergicList = allergens(i)
            else
               allergicList = trim(allergicList) // ' ' //allergens(i)
            end if
         end if
      end do
   end function



end module
