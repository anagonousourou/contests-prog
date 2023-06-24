#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the solve function below.
def solve(s):
    char_list = list(s)
    for i in range(0, len(char_list)):
        if (i-1 in range(0, len(char_list))) and char_list[i - 1] == ' ':
            char_list[i] = char_list[i].upper()
        
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = solve(s)

    fptr.write(result + '\n')

    fptr.close()
