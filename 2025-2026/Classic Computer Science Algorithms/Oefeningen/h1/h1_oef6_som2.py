def som2(n):
    x = 0
    for i in range(1, 2 * n + 1):
        for j in range(1, n + 1):
            x += 1
    return x

inputs = [1,2,3,4,8,16,32,64,128]
for n in inputs:
    print(f"n = {n} returns x = {som2(n)}")