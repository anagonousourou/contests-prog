if __name__ == '__main__':
    x = int(input())
    y = int(input())
    z = int(input())
    n = int(input())
    mylist = [(i, j, k) for k in range(z+1)
     for j in range(y+1) for i in range(x+1) if i+j+k != n]
    mylist.sort()
    mylist = [list(triplet) for triplet in mylist]
    print(mylist)
