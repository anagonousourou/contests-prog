module rna_transcription
   implicit none
contains

! `G` -> `C`
! `C` -> `G`
! `T` -> `A`
! `A` -> `U`
   function to_rna(dna)
      character(*) :: dna
      character(len=len(dna)) :: to_rna
      integer :: i

      do i = 1, len(dna)
         select case (dna(i:i))
          case ('G')
            to_rna(i:i) = 'C'
          case ('C')
            to_rna(i:i) = 'G'
          case ('T')
            to_rna(i:i) = 'A'
          case ('A')
            to_rna(i:i) = 'U'
         end select
      end do
   end function to_rna

end module rna_transcription
