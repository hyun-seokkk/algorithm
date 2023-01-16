n = int(input())
scoring = list(map(int, input().split()))
score = 0
cnt = 0
for ele in scoring:
    if ele == 0:
        cnt = 0
    elif ele == 1:
        cnt += 1
        score += cnt
print(score)
