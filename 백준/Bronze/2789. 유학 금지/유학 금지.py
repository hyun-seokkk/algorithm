import sys
word = sys.stdin.readline().strip()
cam = 'CAMBRIDGE'
word_lst = []
for ele in word:
    if ele not in cam:
        word_lst.append(ele)

print(*word_lst, sep='')