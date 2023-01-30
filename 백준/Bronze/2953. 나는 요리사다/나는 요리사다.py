score = [sum(list(map(int, input().split()))) for _ in range(5)]
print(f'{score.index(max(score)) + 1} {max(score)}')