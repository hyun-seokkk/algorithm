import sys
n = int(sys.stdin.readline())

xy_list = []
for _ in range(n):
    xy_list.append(list(map(int, sys.stdin.readline().split())))
xy_list.sort(key=lambda t:(t[0], t[1]))

for i in xy_list:
    print(i[0], i[1])