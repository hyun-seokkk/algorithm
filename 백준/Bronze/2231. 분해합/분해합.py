import sys

def div_add(n):
    num = [int(i) for i in str(n)]
    return sum(num)

n = int(sys.stdin.readline())

res = []
cnt = 0

for _ in range(n):
    if n == (cnt + div_add(cnt)):
        res.append(cnt)
    cnt += 1

if not(res):
    print(0)
else:
    print(min(res))