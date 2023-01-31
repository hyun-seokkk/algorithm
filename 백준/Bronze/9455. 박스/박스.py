t = int(input())

for _ in range(t):
    m, n = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(m)]

    move = 0
    for i in range(n):
        box = 0
        for j in range(m-1, -1, -1):
            if matrix[j][i] == 1:
                move += m-1-j-box
                box += 1
    print(move)