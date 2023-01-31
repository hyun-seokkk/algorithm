n = int(input())
room = [input() for _ in range(n)]

res = []
sum_num = 0
for i in range(n):
    cnt = 0
    temp = 0
    for j in range(n):
        if room[i][j] == '.':
            temp += 1
        if room[i][j] =='X' or j >= n - 1:
            if temp > 1:
                cnt += 1
            temp = 0
    sum_num += cnt
res.append(sum_num)

sum_num = 0
for i in range(n):
    cnt = 0
    temp = 0
    for j in range(n):
        if room[j][i] == '.':
            temp += 1
        if room[j][i] =='X' or j >= n - 1:
            if temp > 1:
                cnt += 1
            temp = 0
    sum_num += cnt
res.append(sum_num)

print(*res)