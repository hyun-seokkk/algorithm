import sys
input = sys.stdin.readline

n = int(input())
seat = list(map(int, input().split()))
print(len(seat) - len(set(seat)))