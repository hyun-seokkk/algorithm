import sys
input = sys.stdin.readline

def dfs(x, y):
    if x < 0 or y < 0 or x >= n or y >= n:
        return False

    if apt[x][y] == 1 and not visited[x][y]:
        global cnt
        cnt += 1
        visited[x][y] = 1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            dfs(nx, ny)
        return True
    return False

n = int(input())
apt = []
res = 0
cnt = 0  # 단지내 집 카운트
cnt_lst = []

for _ in range(n):
    apt.append(list(map(int, input().strip())))

visited = [[0 for _ in range(n)] for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(n):
    for j in range(n):
        cnt = 0
        if dfs(i, j):
            res += 1
            cnt_lst.append(cnt)
cnt_lst.sort()            

print(res)
print(*cnt_lst, sep='\n')