for tc in range(1, int(input())+1):
    n, m = map(int, input().split())

    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

    nums = []

    if n > m:
        a, b = b, a
    # print(a, b)

    for i in range(len(b) - len(a) + 1):
        sum = 0

        for j in range(len(a)):
            sum += a[j]*b[j+i]
        nums.append(sum)
    
    print(f'#{tc} {max(nums)}')