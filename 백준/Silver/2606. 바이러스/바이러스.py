import sys
from collections import deque
input = sys.stdin.readline

def bfs():
    q = deque()
    q.append(1)
    
    while q:
        x = q.popleft()
        for i in range(1, pc+1):
            if network[x][i] == True and not visited[x][i]:
                q.append(i)
                visited[x][i] = True
    
pc = int(input())
connect = int(input())

network = [[False for _ in range(pc + 1)] for _ in range(pc + 1)]
visited = [[False for _ in range(pc + 1)] for _ in range(pc + 1)]

for _ in range(connect):
    a, b = map(int, input().split())
    network[a][b] = network[b][a] = True

bfs()

cnt = 0
for i in visited:
    if True in i:
        cnt += 1
print(cnt-1)