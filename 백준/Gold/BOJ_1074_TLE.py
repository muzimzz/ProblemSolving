def solve(n, r, c):
    global answer, cnt

    if n > 1:
        solve(n//2, r, c)  
        solve(n//2, r, c+n//2)         
        solve(n//2, r+n//2, c)
        solve(n//2, r+n//2, c+n//2)
    else:
        cnt += 1
        if r==R and c==C:
            answer = cnt


N, R, C = map(int, input().split())
answer = 0
cnt = 0
solve(2**N, 0, 0)
print(answer-1)
