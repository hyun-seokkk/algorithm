import sys
input = sys.stdin.readline

n = int(input())
sticks = [int(input()) for _ in range(n)]
longest = 0
cnt = 0

while sticks:
    now = sticks.pop()
    if now > longest:
        longest = now
        cnt += 1
print(cnt)