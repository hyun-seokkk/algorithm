import sys

def binary_search(arr, start, end, target):
    while start <= end:
        mid = (start + end) // 2

        if arr[mid] == target:
            return True
        elif arr[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return False



n = int(sys.stdin.readline())
n_list = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
m_list = list(map(int, sys.stdin.readline().split()))

n_list.sort()

for ele in m_list:
    if binary_search(n_list, 0, n-1, ele):
        print(1)
    else:
        print(0)