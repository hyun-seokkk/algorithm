dajang = list(map(int, input().split()))

if dajang == sorted(dajang):
    print('ascending')
elif dajang == sorted(dajang, reverse=True):
    print('descending')
else:
    print('mixed')