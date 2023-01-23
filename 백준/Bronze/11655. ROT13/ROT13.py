import sys

sentence = list(sys.stdin.readline().strip('\n'))
#print(sentence)
ord_str = ''
for s in sentence :
    # 대문자일 경우
    if 65 <= int(ord(s)) <= 90 :
        ord_s = chr(int(ord(s))+13)
        if int(ord(s))+13 > 90 :
            ord_s = chr(int(ord(s))+13-26)
    # 소문자일경우 
    elif 97 <= int(ord(s)) <= 122 :
        ord_s = chr(int(ord(s))+13)
        if int(ord(s))+13 > 122 :
            ord_s = chr(int(ord(s))+13-26)
            
    # 그 외 문자
    else :
        ord_s = s 
    ord_str += ord_s
print(ord_str)