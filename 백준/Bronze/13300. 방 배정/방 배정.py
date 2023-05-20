n, k = map(int, input().split())
student = dict()

for i in range(1, 7):
    student[i] = [0, 0]

for _ in range(n):
    s, y = map(int, input().split())
    student[y][s] += 1

cnt = 0

for i in range(1, 7):
    for j in range(2):
        if student[i][j] % k == 0:
            cnt += student[i][j] // k
        else:
            cnt += student[i][j] // k + 1
print(cnt)