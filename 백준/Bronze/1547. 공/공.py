n = int(input())
cup = [1, 2, 3]
for _ in range(n):
    x, y = map(int, input().split())
    x = cup.index(x)
    y = cup.index(y) 
    cup[x], cup[y] = cup[y], cup[x]
print(cup[0])