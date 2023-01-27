import sys
input = sys.stdin.readline
num = list(map(int, input().split()))
print(sorted(num)[1])