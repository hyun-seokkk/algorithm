def solution(quiz):
    answer = []
    for ele in quiz:
        left, right = ele.split('=')  # 좌항 우항 분리
        left = left.split()  # 숫자와 연산자 분리
        right = int(right)
        
        if left[1] == '+':
            if int(left[0]) + int(left[2]) == right:
                answer.append('O')
            else:
                answer.append('X')
        elif left[1] == '-':
            if int(left[0]) - int(left[2]) == right:
                answer.append('O')
            else:
                answer.append('X')
            
        
    
    return answer