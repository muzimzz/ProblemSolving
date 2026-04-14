MAX_ARR_SIZE = 100000
MIN_VALUE = -1000

N = int(input())
arr = list(map(int, input().split()))
dp = [MIN_VALUE] * MAX_ARR_SIZE
dp[0] = arr[0]

for i in range(1, N):
    dp[i] = max(arr[i], arr[i]+dp[i-1])

answer = max(dp)

print(answer)