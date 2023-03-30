if __name__ == '__main__':
    n = int(input())
    arr = map(int, input().split())
    arr = list(arr)
    arr.sort(reverse= True)
    theMax = arr[0]
    for i in range(len(arr)):
        if arr[i] != theMax:
            print(arr[i])
            break