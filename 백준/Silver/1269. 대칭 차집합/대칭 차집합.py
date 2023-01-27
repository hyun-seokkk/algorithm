import sys
input = sys.stdin.readline

a, b = map(int, input().split())
a_lst = set(map(int, input().split()))
b_lst = set(map(int, input().split()))
print(len(a_lst ^ b_lst))