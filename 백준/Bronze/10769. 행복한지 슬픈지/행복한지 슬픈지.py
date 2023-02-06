message = input()
emoji = [':-)', ':-(']
res = [message.count(i) for i in emoji]
if res[0] < res[1]:
        print('sad')
elif res[0] > res[1]:
    print('happy')
elif res[0] == 0 and res[1] == 0:
    print('none')
elif res[0] == res[1]:
    print('unsure')
