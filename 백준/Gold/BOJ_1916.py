import heapq
import sys

def bfs(start):
    hq = []
    heapq.heappush(hq, (0, start))
    dist[start] = 0
    while hq:
        cost, curr = heapq.heappop(hq)

        if (cost > dist[curr]):
            continue

        for target in graph[curr]:
            next, new_cost = target
            if dist[next] > cost + new_cost:
                dist[next] = cost + new_cost
                heapq.heappush(hq, (new_cost, next))


N = int(input())
M = int(input())
dist = [float('inf')] * N
graph = [[] for _ in range(N)]
for i in range(M):
    S, E, cost = map(int, sys.stdin.readline().split())
    graph[S-1].append((E-1, cost));

start, end = map(int, sys.stdin.readline.split())
bfs(start)
print(dist[end])



