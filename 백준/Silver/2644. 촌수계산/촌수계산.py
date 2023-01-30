import sys
input = sys.stdin.readline

def dfs(k):
    for i in range(len(matrix[k])):
        if matrix[k][i] and not visited[i]:
            #깊이 차이를 구하기 위해 직전 탐색 거리 + 1
            visited[i] = visited[k] + 1
            dfs(i)
    

n = int(input())
a, b = map(int, input().split())
m = int(input())

relation = [list(map(int, input().split())) for _ in range(m)]
matrix = [[0]*(n+1) for _ in range(n+1)]
visited = [0]*(n+1)
for i, j in relation:
    matrix[i][j] = matrix[j][i] = 1
dfs(a)
if visited[b] > 0:
    print(visited[b])
else:
    print(-1)