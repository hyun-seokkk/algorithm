# 각 자리수의 합 반환해주는 함수
def div_add(n):
    num = [int(i) for i in str(n)]
    return sum(num)

n = int(input())
res = 0

# 0부터 n까지 순회
for num in range(1, n+1):
    if n == (num + div_add(num)): # n이 생성자라면
        res = num 
        break

print(res)