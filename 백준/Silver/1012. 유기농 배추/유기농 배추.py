import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

def dfs(x, y):
    
    if x < 0 or x >= n or y < 0 or y >= m:
        return False
    if farm[x][y] == 1:
        farm[x][y] = 0
        dfs(x, y+1)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x-1, y)
        return True
    else:
        return False

t = int(input())
for _ in range(t):
    cnt = 0
    m, n, k = map(int, input().split())
    farm = [[0 for col in range(m)] for row in range(n)]

    for i in range(k):
        x, y = map(int, input().split())
        farm[y][x] = 1

    for i in range(n):
        for j in range(m):
            if dfs(i, j):
                cnt += 1
    print(cnt)
