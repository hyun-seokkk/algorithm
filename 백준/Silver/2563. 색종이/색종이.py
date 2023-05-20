n = int(input())
res = []
for _ in range(n):
    x, y = map(int, input().split())
    for i in range(x, x+10):
        for j in range(y, y+10):
            res.append((i, j))
print(len(set(res)))