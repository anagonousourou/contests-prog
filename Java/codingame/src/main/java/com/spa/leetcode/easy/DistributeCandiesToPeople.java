package com.spa.leetcode.easy;

public class DistributeCandiesToPeople {

    // https://leetcode.com/problems/distribute-candies-to-people/submissions/1561276238/
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int round = 1;

        // Find what is the maximum number of rounds
        while ((num_people * round * (1 + num_people * round) / 2) <= candies){
            round++;
        }
        // this gives use the number of full rounds
        round--;

        // set the number of candies taken in each full round
        // each person number of candies is equal to the sum of
        // arithmetic series with first term i + 1 and progression 'num_people'
        for (int i = 0; i < result.length; i++) {
            int lastTerm = (i + 1) + (round - 1) * num_people;
            result[i] =  round * ((i + 1) + lastTerm) / 2  ;
        }

        // Add the candies for the last round
        int lastTerm = 1 +  (round * num_people - 1);
        int candiesUsed = (num_people * round * (1 + num_people * round) / 2);

        int i = 0;
        while (candiesUsed < candies){
            if(candiesUsed + lastTerm + i + 1 <= candies){
                result[i] += lastTerm + i + 1;
                candiesUsed += lastTerm + i + 1;
            }else{
                result[i] += (candies - candiesUsed);
                break;
            }
            i++;
        }

        return result;
    }
}
