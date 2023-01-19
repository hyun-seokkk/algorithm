import sys
dial = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']
word = sys.stdin.readline().strip()
res = 0
for i in word:
    for j in range(len(dial)):
        if i in dial[j]:
            res += j+3
print(res)