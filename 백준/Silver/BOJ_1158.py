N, K = map(int, input().split())

li = [i for i in range(1, N+1)]
answer = []

cnt, idx = 0, 0
while li:
    idx = (idx + K - 1) % len(li)
    answer.append(li.pop(idx))

print('<', end='')
print(*answer, sep=', ', end='')
print('>')
