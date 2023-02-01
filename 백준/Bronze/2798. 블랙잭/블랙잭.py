n, m = map(int, input().split())
cards = list(map(int, input().split()))
sum_nums = []
for i in range(n-2):
    for j in range(i+1, n-1):
        for k in range(j+1, n):
            sum_num = cards[i]+cards[j]+cards[k]
            if sum_num <= m:
                sum_nums.append(sum_num)
print(max(sum_nums))