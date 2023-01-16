n, x = map(int, input().split())
a = list(map(int, input().split()))

[print(ele, end=' ') for ele in a if ele < x]