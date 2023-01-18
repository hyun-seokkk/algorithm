import sys
word = sys.stdin.readline().strip()

if len(word) % 10 == 0:
    n = len(word) // 10
else:
    n = len(word) // 10 + 1

for i in range(n):
    if i != n:
        print(word[i*10:i*10+10])
    else:
        print(word[i*10:])