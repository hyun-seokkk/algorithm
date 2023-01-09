num = list(map(int, input().split()))

pieces = [1, 1, 2, 2, 2, 8]

for i in range(len(pieces)):
    print(pieces[i] - num[i], end=' ')