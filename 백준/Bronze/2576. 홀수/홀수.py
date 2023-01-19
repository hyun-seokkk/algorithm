import sys
num = [int(sys.stdin.readline()) for _ in range(7)]
odd_num = [i for i in num if i % 2 == 1]
if odd_num:
    print(sum(odd_num), min(odd_num), sep='\n')
else:
    print(-1)