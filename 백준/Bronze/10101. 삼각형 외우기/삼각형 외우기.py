import sys
input = sys.stdin.readline

triangle = [int(input()) for _ in range(3)]
triangle_lst = ['Equilateral', 'Isosceles', 'Scalene']
equal_angle = len(set(triangle))
if sum(triangle) != 180:
    print('Error')
else:
    print(triangle_lst[equal_angle - 1])