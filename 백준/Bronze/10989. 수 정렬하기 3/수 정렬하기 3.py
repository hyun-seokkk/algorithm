import sys
input = sys.stdin.readline
n = int(input())
my_dict = dict()

for i in range(10001):
    my_dict[i] = 0

for _ in range(n):
    num = int(input())
    my_dict[num] += 1

for i in range(10001):
    if my_dict[i] != 0:
        for _ in range(my_dict[i]):
            print(i)