a, b = input().split()
b = sum(list(map(int, b)))
res = 0
for i in a:
    res += b * int(i)
print(res)