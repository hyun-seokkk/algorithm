n = int(input())
for i in reversed(range(n+1)):
    now = str(i)
    if len(now) == now.count('4') + now.count('7'):
        print(now)
        break