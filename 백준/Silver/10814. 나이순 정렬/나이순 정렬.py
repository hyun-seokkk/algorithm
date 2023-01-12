import sys
n = int(sys.stdin.readline())

p_list = []
for _ in range(n):
    people = []
    age, name = sys.stdin.readline().split()
    people.append(int(age))
    people.append(name)
    p_list.append(people)

p_list.sort(key=lambda x:x[0])


for i in p_list:
    for j in i:
        print(j, end=' ')
    print()