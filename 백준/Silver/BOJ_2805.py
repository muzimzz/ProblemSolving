import sys

N, M = map(int, sys.stdin.readline().split())
trees = list(map(int, sys.stdin.readline().split()))

left, right = 0, max(trees)

while left <= right:
    T = 0
    mid = (left + right) // 2
    for tree in trees:
        T += max(0, tree - mid)
    
    if T >= M:
        answer = mid
        left = mid + 1
    else:
        right = mid - 1


print(answer)
