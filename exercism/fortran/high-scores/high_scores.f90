
module high_scores
   implicit none
contains

   function scores(score_list)
      integer, dimension(:) :: score_list
      integer, allocatable, dimension(:) :: scores
      scores = score_list
   end function


   function latest(score_list)
      integer, dimension(:) :: score_list
      integer :: latest
      latest = score_list(size(score_list))
   end function

   function personalBest(score_list)
      integer, dimension(:) :: score_list
      integer :: personalBest
      personalBest = maxval(score_list)
   end function


   function personalTopThree(score_list)
      integer, dimension(:) :: score_list
      integer, dimension(size(score_list)) :: scores_copy
      integer, dimension(3) :: personalTopThree
      integer :: i,j ,tmp
      scores_copy = score_list
      if (size(score_list) == 1) then
         personalTopThree(1) = maxval(score_list)
         personalTopThree(2) = 0
         personalTopThree(3) = 0
      else if (size(score_list) == 2) then
         personalTopThree(1) = maxval(score_list)
         personalTopThree(2) = minval(score_list)
         personalTopThree(3) = 0
      else
         do j = 1,3
            do i = size(scores_copy) - 1 ,j,-1
               if (scores_copy(i) < scores_copy(i + 1)) then
                  tmp = scores_copy(i)
                  scores_copy(i) = scores_copy(i + 1)
                  scores_copy(i + 1) = tmp
               end if
            end do
         end do
         personalTopThree = scores_copy(1:3)
      endif
   end function


end module
