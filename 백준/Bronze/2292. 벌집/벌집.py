n = int(input())

cnt = 1
mul = 6
sum = 1


if n == 1:
    print(1)
else:
    while 1:
        sum += mul*cnt
        cnt += 1
        if sum >= n:
            print(cnt)
            break


