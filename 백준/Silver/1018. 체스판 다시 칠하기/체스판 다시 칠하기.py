
n, m = map(int, input().split())

board = list()
for _ in range(n):
    str = input()
    board.append(str)



cnt_list = list()

for k in range(n-7):
    for l in range(m-7):
            cnt = 0
            for i in range(k, k+8): #시작점이 w일 경우
                for j in range(l, l+8):
                    if i % 2 == 0 and j % 2 == 0:  #시작점이 W면 짝수, 짝수 / 홀수, 홀수가 W
                        if board[i][j] == 'B':
                            cnt += 1
                    elif i % 2 == 1 and j % 2 == 1:
                        if board[i][j] == 'B':
                            cnt += 1
                    elif i % 2 == 0 and j % 2 == 1:
                        if board[i][j] == 'W':
                            cnt += 1
                    elif i % 2 == 1 and j % 2 == 0:
                        if board[i][j] == 'W':
                            cnt += 1
            cnt_list.append(cnt)

            cnt = 0

            for i in range(k, k+8): #시작점이 B일 경우
                for j in range(l, l+8):
                    if i % 2 == 0 and j % 2 == 0: 
                        if board[i][j] == 'W':
                            cnt += 1
                    elif i % 2 == 1 and j % 2 == 1:
                        if board[i][j] == 'W':
                            cnt += 1
                    elif i % 2 == 0 and j % 2 == 1:
                        if board[i][j] == 'B':
                            cnt += 1
                    elif i % 2 == 1 and j % 2 == 0:
                        if board[i][j] == 'B':
                            cnt += 1
            cnt_list.append(cnt)

print(min(cnt_list))