import sys
input = sys.stdin.readline

n = int(input())
people = list(map(int, input().split()))
people.sort()
res = []
for i in range(n):
    temp = 0
    for j in range(i+1):
        temp += people[j]
    res.append(temp)

print(sum(res))