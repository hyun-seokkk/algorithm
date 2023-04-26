t = int(input())

for tc in range(1, t+1):
    n, m = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    # print(matrix)
    kill_log = []

    for i in range(n):
        for j in range(n):
            now = 0
            for m1 in range(m):
                for m2 in range(m):
                    if i+m1 < n and j + m2 < n:
                        now += matrix[i+m1][j+m2]
            kill_log.append(now)
    print(f'#{tc} {max(kill_log)}')
