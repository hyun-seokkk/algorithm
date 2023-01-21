import sys
from collections import deque

def bfs():
    while queue:
        h, x, y = queue.popleft()
        visited[h][x][y] = True

        for i in range(6):
            nh = h + dh[i]
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nh < height and 0 <= nx < n and 0 <= ny < m and matrix[nh][nx][ny] == 0 and not visited[nh][nx][ny]:
                queue.append((nh, nx, ny))
                matrix[nh][nx][ny] = matrix[h][x][y] + 1

    

input = sys.stdin.readline

m, n, height = map(int, input().split())

matrix = []
for _ in range(height):
    temp = []
    for _ in range(n):
        temp.append(list(map(int, input().split())))
    matrix.append(temp)
visited = [[[False for i in range(m)] for j in range(n)] for k in range(height)]

queue = deque()

dh = [-1, 1, 0, 0, 0, 0]
dx = [0, 0, -1, 1, 0, 0]
dy = [0, 0, 0, 0, -1, 1]

for i in range(height):
    for j in range(n):
        for k in range(m):
            if matrix[i][j][k] == 1:
                queue.append((i, j, k))

bfs()

zero = 0

for i in matrix:
    for j in i:
        for k in j:
            if k == 0:
                zero += 1
res = 0
if zero:
    print(-1)
else:
    for i in matrix:
        for j in i:
            res = max(res, max(j))
    print(res - 1)