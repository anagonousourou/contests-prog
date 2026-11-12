

class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        dividend_copy = abs(dividend)
        divisorCopy = abs(divisor)
        res = 0;
        while dividend_copy >= divisorCopy : 
            res += 1
            dividend_copy -= divisorCopy
        if (dividend < 0 and divisor < 0) or (dividend > 0 and divisor > 0): 
            return res
        else:
            return -res