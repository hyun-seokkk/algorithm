station = [list(map(int, input().split())) for _ in range(4)]
now = 0
res = []
for i in station:
    now += i[1] - i[0]
    res.append(now)
print(max(res))
