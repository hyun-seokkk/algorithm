import sys
input = sys.stdin.readline
rubber_duck = []
start = input().strip()
while 1:
    temp = input().strip()
    if temp == '고무오리 디버깅 끝':
        break
    if temp == '문제':
        rubber_duck.append('문제')
    elif temp == '고무오리':
        if rubber_duck:
            rubber_duck.pop()
        else:
            rubber_duck.append('문제')
            rubber_duck.append('문제')
if rubber_duck:
    print('힝구')
else:
    print('고무오리야 사랑해')