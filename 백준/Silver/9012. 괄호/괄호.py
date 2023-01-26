import sys
input = sys.stdin.readline

t = int(input())
lst = [input().strip() for _ in range(t)]

for i in range(t):
    while '()' in lst[i]:
        lst[i] = lst[i].replace('()', '')

for ele in lst:
    if ele == '':
        print('YES')
    else:
        print('NO')