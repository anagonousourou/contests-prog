package com.spa.leetcode.medium;

public class SolvingQuestionsWithBrainpower {

    // https://leetcode.com/problems/solving-questions-with-brainpower/submissions/1593135360/

public long mostPoints(int[][] questions) {
    int n = questions.length;
    // Create an array to store the maximum points up to each question.
    long[] dp = new long[n];
    dp[n - 1] = questions[n- 1][0];
    // Iterate from the last question to the first.
    for (int i = n - 2; i >= 0; i--) {
        int points = questions[i][0];
        int cooldown = questions[i][1];
        
        // Calculate the next question index we can jump to, considering the cooldown period.
        int nextQuestionIndex = Math.min(i + cooldown + 1, n);
        
        // Update dp[i] with the maximum of answering this question or skipping it.
        dp[i] = Math.max(dp[i + 1] , points + (nextQuestionIndex < n ? dp[nextQuestionIndex] : 0));
    }
    
    // The answer is the best score at the first question.
    return dp[0];
}

}
