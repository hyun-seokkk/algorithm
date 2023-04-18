n = int(input())
nums = [3, 6, 9]

for ele in range(1, n+1):
    now = str(ele)
    jjak = 0
    for bele in now:
        if int(bele) in nums:
            jjak += 1
    
    if jjak == 0:
        print(ele, end=' ')
    else:
        for i in range(jjak):
            print('-', end='')
        print(end=' ')