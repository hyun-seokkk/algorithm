for tc in range(1, int(input())+1):
    n, m = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    res = 0

    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0] # 상,하,좌,우 순

    for i in range(n):
        for j in range(n):
            temp = matrix[i][j]
            for k in range(1, m): # 스프레이 세기
                for l in range(4):
                    x = i + dx[l] * k
                    y = j + dy[l] * k
                    if 0 <= x < n and 0 <= y < n:
                        temp += matrix[x][y]
            if temp > res:
                res = temp

    dx = [1, 1, -1, -1]
    dy = [-1, 1, 1, -1]

    for i in range(n):
        for j in range(n):
            temp = matrix[i][j]
            for k in range(1, m): # 스프레이 세기
                for l in range(4):
                    x = i + dx[l] * k
                    y = j + dy[l] * k
                    if 0 <= x < n and 0 <= y < n:
                        temp += matrix[x][y]
            if temp > res:
                res = temp

    print(f'#{tc} {res}')