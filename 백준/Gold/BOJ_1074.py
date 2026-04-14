def solve(n, r, c):
    global answer, cnt
    if n == 1:
        answer = cnt
        return
    
    half = n//2
    quater = half * half

    # Z-order
    if R < r+half and C < c+half:   # 왼쪽 위
        solve(half, r, c)  
    # if R < r+half and c+half <= C < half:
    elif R < r+half and C < c+n:    # 오른쪽 위
        cnt += quater    
        solve(half, r, c+half)   
    # if r+half <= R < r+n and C < c+half:
    elif R < r+n and C < c+half:    # 왼쪽 아래
        cnt += 2*quater   
        solve(half, r+half, c)
    # if r+half <= R < r+n and c+half <= C < half:
    else:                           # 오른쪽 아래
        cnt += 3*quater
        solve(half, r+half, c+half) 


N, R, C = map(int, input().split())
answer = 0
cnt = 0
solve(2**N, 0, 0)
print(answer)
