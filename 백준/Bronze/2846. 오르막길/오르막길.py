n = int(input())
road = list(map(int, input().split()))
first = True
start = 0
end = 0
res = []
for i in range(int(n-1)):
    if road[i] < road[i+1] and first:
        start = road[i]
        first = False
    elif i == n-2 and road[i] < road[i+1] and not first:
        end = road[i+1]
        res.append(end - start)
        first = True
    elif road[i] >= road[i+1] and not first:
        end = road[i]
        res.append(end-start)
        first = True

if res:
    print(max(res))
else:
    print(0)