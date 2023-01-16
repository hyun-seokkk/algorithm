n = int(input())
string = list(input())
sum = 0
m = 1234567891

str_to_num = [ord(ele) - 96 for ele in string]

for i in range(len(str_to_num)):
    sum += ((str_to_num[i]) * (31**i))
print(sum)
