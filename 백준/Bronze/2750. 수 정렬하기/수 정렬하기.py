import sys
sys.setrecursionlimit(10**6)

def quick_sort(arr, start, end):
    if start >= end:
        return
    pivot = start
    left = start+1
    right = end

    while left <= right: # 엇갈릴 때까지
        while left <= end and arr[left] <= arr[pivot]:
            left += 1
        while right > start and arr[right] >= arr[pivot]:
            right -= 1

        if left > right:
            arr[pivot], arr[right] = arr[right], arr[pivot]
        else:
            arr[left], arr[right] = arr[right], arr[left]
    quick_sort(arr, start, right-1)
    quick_sort(arr, right+1, end)


n = int(sys.stdin.readline())
lst = []
for _ in range(n):
    lst.append(int(sys.stdin.readline()))
quick_sort(lst, 0, len(lst)-1)

for ele in lst:
    print(ele)