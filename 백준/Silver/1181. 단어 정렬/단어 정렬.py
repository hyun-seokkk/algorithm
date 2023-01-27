import sys
input = sys.stdin.readline
n = int(input())
words = set()
for _ in range(n):
    words.add(input().strip())
print(*sorted(sorted(words), key=len), sep='\n')