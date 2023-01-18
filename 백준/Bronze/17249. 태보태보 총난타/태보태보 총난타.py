import sys
jansang = sys.stdin.readline().strip()
l_idx = jansang.index('(')
r_idx = jansang.index(')')

left = [jansang[i] for i in range(len(jansang)) if l_idx > i ]
right = [jansang[i] for i in range(len(jansang)) if r_idx < i ]
print(left.count('@'), right.count('@'))