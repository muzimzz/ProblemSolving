
N, M = map(int, input().split())
board = [list(input()) for _ in range(N)]

answer_while = 0
answer_black = 0


for i in range(N-8+1):
    for j in range(M-8+1):
        print(i, j)

    