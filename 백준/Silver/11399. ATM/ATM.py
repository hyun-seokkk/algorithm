import sys
input = sys.stdin.readline

n = int(input())
people = list(map(int, input().split()))
people.sort()
temp = 0
res = []
for i in range(n):
    for j in range(i+1):
        temp += people[j]

print(temp)