def som1(n):
    x = 0
    for i in range (1, n + 1):
        x += 1
    return x

input = [1,2,4,8,16,32,64,128]

for n in input:
    print(f"n = {n} returns x = {som1(n)}")