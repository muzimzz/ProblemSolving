N, M = map(int, input().split())
time = []
for _ in range(N):
    time.append(list(map(int, input().split())))



for start in range(N):
    for end in range(N):
        for mid in range(N):
            if time[start][end] > time[start][mid] + time[mid][end]:
                time[start][end] = time[start][mid] + time[mid][end]

for _ in range(M):
    s, e, t = map(int, input().split())
    if time[s][e] <= t:
        print("Enjoy other party")
    else:
        print("Stay here")







