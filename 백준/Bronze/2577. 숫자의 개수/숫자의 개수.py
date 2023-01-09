a = int(input())
b = int(input())
c = int(input())

mul = a*b*c
mul = str(mul)

for i in range(10):
    print(mul.count(str(i)))