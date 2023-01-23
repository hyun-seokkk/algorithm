import sys
from collections import deque
input = sys.stdin.readline

def dfs(k):

    # k 노드 방문처리
    visited_dfs[k] = True
    print(k, end=' ')

    for i in range(1, n + 1):
        # 아직 i노드를 방문하지 않았고 k노드 (스택 최상단 노드)와 i노드가 연결되어 있다면
        if not visited_dfs[i] and graph[k][i]:
            #그 i 값으로 dfs 수행
            dfs(i)

def bfs(k):
    q = deque()
    q.append(k)
    # k노드 방문처리
    visited_bfs[k] = True

    # 큐가 빌때까지
    while q:
        # 큐의 가장 왼쪽 값 꺼냄
        v = q.popleft()
        print(v, end=' ')

        for i in range(1, n+1):
            # 아직 i노드를 방문하지 않았고 v노드(큐의 가장 왼쪽 노드)와 i노드가 연결되어 있다면
            if not visited_bfs[i] and graph[v][i]:
                # i노드를 큐에 넣고 방문처리
                q.append(i)
                visited_bfs[i] = True

n, m, k = map(int , input().split())
graph = [[False] * (n + 1) for _ in range(n + 1)]

# 인덱스는 각 노드, 해당 인덱스의 값들은 노드끼리 연결되어 있다면 True
for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = True

visited_dfs = [False for _ in range(n+1)]
visited_bfs = [False for _ in range(n+1)]

dfs(k)
print()
bfs(k)