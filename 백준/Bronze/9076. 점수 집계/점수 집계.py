for _ in range(int(input())):
    score = sorted(list(map(int, input().split())))
    score.pop(0)
    score.pop()
    if max(score) - min(score) >= 4:
        print('KIN')    
    else:
        print(sum(score))