from collections import deque
import sys

N, K = map(int, input().split())
limit = 100001
visited = [0] * limit
def BFS():
    queue = deque()
    queue.append(N)
    while queue:
        x = queue.popleft()       
        if x == K:
            print(visited[x])
            break
        for i in (x - 1, x + 1, x * 2):
            if 0 <= i < limit and not visited[i]:    
                visited[i] = visited[x] + 1           
                queue.append(i)                       
BFS()
