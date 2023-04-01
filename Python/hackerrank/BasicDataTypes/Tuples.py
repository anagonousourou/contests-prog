if __name__ == '__main__':
    n = int(input())
    integer_tuple = tuple(list(map(int, input().split())))
    print(hash(integer_tuple))
    