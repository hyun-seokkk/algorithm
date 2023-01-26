import sys
from collections import deque
input = sys.stdin.readline

n = int(input())

q = deque(range(1, n+1))

while len(q) != 1:
    print(q.popleft(), end=' ')
    # q.append(q.popleft())
    q.rotate(-1)
print(q[0])