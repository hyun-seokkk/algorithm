import sys
from collections import deque
input = sys.stdin.readline

def bfs():

    # 0,0부터 bfs를 수행하기 위한 큐 생성
    q = deque()
    q.append((0, 0))
    
    while q:    
        # 큐를 꺼내서 x, y에 저장
        x, y = q.popleft()
        visited[x][y] = 1

        # (x, y)좌표에서 상하좌우 한 번씩 이동하기 위해 4번 반복
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # nx, ny가 maze크기 내부 / (nx, ny) 값이 이동 가능한 1이면서 아직 방문을 안 했다면면
            if 0 <= nx < n and 0 <= ny < m and maze[nx][ny] == 1 and not visited[nx][ny]:
                # (nx, ny)를 큐에 삽입 후 방문처리
                q.append((nx, ny))
                visited[nx][ny] = 1

                #거리를 구하기 위해 직전 좌표 값보다 1씩 크게 저장
                maze[nx][ny] = maze[x][y] + 1

n, m = map(int, input().split())
maze = []
# maze 채우기
for _ in range(n):
    maze.append(list(map(int, input().strip())))

# maze 크기에 맞게 방문처리 리스트 생성
visited = [[0 for _ in range(m)] for _ in range(n)]

# 상하좌우 이동을 위한 좌표 리스트
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


bfs()

print(maze[n-1][m-1])