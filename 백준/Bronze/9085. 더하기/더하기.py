import sys
t = int(sys.stdin.readline())
for _ in range(t):
    n = int(sys.stdin.readline())
    lst = list(map(int, sys.stdin.readline().split()))

    print(sum(lst))