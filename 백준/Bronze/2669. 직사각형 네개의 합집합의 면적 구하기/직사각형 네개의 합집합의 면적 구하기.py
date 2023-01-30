matrix = [[0]*101 for _ in range(101)]
square = [list(map(int, input().split())) for _ in range(4)]
cnt = 0
for i in square:
    for j in range(i[0], i[2]):
        for k in range(i[1], i[3]):
            if matrix[j][k] == 0:
                matrix[j][k] = 1
                cnt += 1
print(cnt)