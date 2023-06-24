n = int(input())
btns = [300, 60, 10]

if n % 10 != 0:
    print(-1)
else:
    for btn in btns:
        print(n // btn, end=' ')
        n %= btn