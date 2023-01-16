n = int(input())
cute_vote = []
for _ in range(n):
    cute_vote.append(int(input()))
if cute_vote.count(1) < cute_vote.count(0):
    print('Junhee is not cute!')
else:
    print('Junhee is cute!')