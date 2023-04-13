T = int(input())

for tc in range(1, T+1):
    n = int(input())
    res = 0
    command=[]

    for _ in range(n):
        temp = list(map(int, input().split()))
        command.append(temp)
    now = 0

    speed = 0
    for ele in command:
        type = ele[0]
        if type == 1:
            speed += ele[1]
            res += speed
        elif type == 2:
            if speed >= ele[1]:
                speed -= ele[1]
            else:
                speed = 0
            res += speed
        else:
            res += speed
    print(f'#{tc} {res}')