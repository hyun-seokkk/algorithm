k, n = map(int, (input().split()))
lan_list = []
for i in range(k):
    lan = int(input())
    lan_list.append(lan)

start = 1
half = 0
end = max(lan_list)
total = 0

while start <= end:
    total = 0
    half = (start + end) // 2
    for elements in lan_list:
        total += elements // half
    if total >= n:
        start = half + 1
    elif total < n:
        end = half - 1
    
print(end)