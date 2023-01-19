import sys
from collections import Counter
n = int(sys.stdin.readline())
log = [sys.stdin.readline().strip().split() for _ in range(n)]
""" empolyee = []
for i in log:
    empolyee.append(i[0]) """
dic = {}
for i in log:
    dic[i[0]] = i[1]
enter_dic = {}
for k, v in dic.items():
    if v == 'enter':
        enter_dic[k] = [v]
print(*sorted(enter_dic, reverse=True), sep='\n') 