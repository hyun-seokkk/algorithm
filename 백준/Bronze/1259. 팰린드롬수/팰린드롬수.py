while 1:
    nums = int(input())

    if(nums == 0):
        break
    elif (str(nums) == str(nums)[::-1]):
        print('yes')
    else:
        print('no')
    