import sys
sys.setrecursionlimit(10**6)

dx = [-1, 1, 0, 0, -1, 1, -1, 1]
dy = [0, 0, -1, 1, 1, -1, -1, 1]

def dfs(x, y):
    if x < 0 or x >= h or y < 0 or y >= w:
        return 0

    if matrix[x][y]:
        for i in range(8):
            nx = x+dx[i]
            ny = y+dy[i]
            matrix[x][y] = 0 #방문처리
            dfs(nx, ny)
        return 1
    return 0

while 1:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break

    matrix = [list(map(int, input().split())) for _ in range(h)]
    total = 0
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            if dfs(i, j):
                total += 1
    print(total)