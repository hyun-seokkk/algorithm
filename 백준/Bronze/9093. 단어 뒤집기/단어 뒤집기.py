import sys
t = int(sys.stdin.readline())
for _ in range(t):
    str = sys.stdin.readline().split()
    #print(str)
    for ele in str:
        print(ele[::-1], end=' ')
    print()