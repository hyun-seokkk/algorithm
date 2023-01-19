import sys
cro_alp = ['c=', 'c-', 'd-', 'lj', 'nj', 's=']
dz = ['dz=']
z = ['z=']
word = sys.stdin.readline().strip()
res = len(word)
for i in range(len(word)):
    if word[i:i+2] in cro_alp:
        res -= 1
    if word[i:i+3] in dz:
        res -= 1
    if word[i:i+2] in z:
        res -= 1
print(res)