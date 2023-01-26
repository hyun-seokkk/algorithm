import sys
input = sys.stdin.readline

t = int(input())
change = [int(input()) for _ in range(t)]
change_lst = [25, 10, 5, 1]
temp = 0
for ele in change:
    for i in change_lst:
        print(ele // i, end=' ')
        ele %= i
    print()