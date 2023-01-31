lst = [input() for _ in range(5)]
length = [len(i) for i in lst]
for i in range(max(length)):
    for j in range(5):
        if len(lst[j]) > i:
            print(lst[j][i], end='')