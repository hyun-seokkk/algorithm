tc = int(input())

for i in range(0,tc):
    num, str = input().split()
    num = int(num)
    for j in range(len(str)):
        for k in range(num):
            print(str[j],end='')
    print()