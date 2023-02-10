from collections import deque
n, k = map(int, input().split())
q = deque(list(range(1, n+1)))
res = []

while q:
    q.rotate(-k + 1)
    res.append(q.popleft())

print('<', end='')
for i in range(n):
    if i == n-1:
        print(f'{res[i]}>')
    else:
        print(res[i], end=', ')