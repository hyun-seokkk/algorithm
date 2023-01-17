import sys

lst = []
for _ in range(9):
    lst.append(int(sys.stdin.readline()))

print(max(lst))
print(lst.index(max(lst))+1)