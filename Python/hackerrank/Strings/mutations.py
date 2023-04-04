def mutate_string(string, position, character):
    char_list = list(string)
    char_list[position] = character
    return ''.join(char_list)

if __name__ == '__main__':
    s = input()
    i, c = input().split()
    s_new = mutate_string(s, int(i), c)
    print(s_new)