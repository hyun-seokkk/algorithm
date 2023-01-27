import sys
import heapq
input = sys.stdin.readline

nums = []
n = int(input())

for _ in range(n):
    x = int(input())
    if x:
        heapq.heappush(nums, (abs(x), x))
    else:
        if nums:
            print(heapq.heappop(nums)[1])
        else:
            print(0)