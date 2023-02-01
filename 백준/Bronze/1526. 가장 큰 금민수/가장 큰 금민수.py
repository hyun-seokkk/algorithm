n = int(input())
for i in reversed(range(n+1)):
    res = ''
    for j in str(i):
        if j == '4' or j == '7':
            res += j
    if res and i == int(res):
        print(i)
        break