"""
From https://www.hackerrank.com/challenges/swap-case/problem?isFullScreen=true
"""
def swap_case(s_string):
    """
    change the case of the letter in s, lowercase -> uppercase and uppercase -> lowercase
    :param s
    """
    return str.join("", [character.upper() if character.islower() else character.lower() for character in s_string ])

if __name__ == '__main__':
    s = input()
    result = swap_case(s)
    print(result)