from collections import deque

n = int(input())
for _ in range(n):
    num, target = map(int, input().split())
    lst = list(map(int, input().split()))
    idx = [0] * num
    idx[target] = 1
    
    lst_ = deque(lst)
    idx_ = deque(idx)
    cnt = 0
    while 1:
        if lst_[0] == max(lst_):
            cnt += 1

            if idx_[0]:
                print(cnt)
                break
            else:
                lst_.popleft()
                idx_.popleft()
        else:
            lst_.rotate(-1)
            idx_.rotate(-1)