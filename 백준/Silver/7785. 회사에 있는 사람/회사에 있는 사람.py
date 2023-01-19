import sys
n = int(sys.stdin.readline())
log = {}
for i in range(n):
    a, b = sys.stdin.readline().split()
    if b == 'enter':
        log[a] = b
    else:
        log.pop(a)
print(*sorted(log, reverse=True), sep='\n')