def solution(s):
    answer = 0
    res = []
    
    if len(s) == 1:
        return 1
    for i in range(1, (len(s)//2) + 1):
        saveword = ''
        cnt = 1
        tmp = s[:i]
        
        for j in range(i, len(s), i):
            if tmp == s[j:j+i]:
                cnt += 1
            else:
                if cnt != 1:
                    saveword = saveword + str(cnt) + tmp
                else:
                    saveword = saveword + tmp
                tmp = s[j:i+j]
                cnt = 1
        if cnt != 1:
            saveword = saveword + str(cnt) + tmp
        else:
            saveword = saveword + tmp
        res.append(len(saveword))
    answer = min(res)
    return answer