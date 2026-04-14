def L(node):
    if node == '.':
        return

    print(node, end='')
    L(tree[node][0])
    L(tree[node][1])

def M(node):
    if node == '.':
        return

    M(tree[node][0])
    print(node, end='')
    M(tree[node][1])

def R(node):
    if node == '.':
        return
    
    R(tree[node][0])
    R(tree[node][1])
    print(node, end='')

N = int(input())
tree = {}
for i in range(N):
    A, B, C = input().split()
    tree[A] = (B, C)
    if i == 0:
        root = A

L(root)
print()
M(root)
print()
R(root)
