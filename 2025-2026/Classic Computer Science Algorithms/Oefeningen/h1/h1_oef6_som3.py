def som3(n):
    x = 0
    for i in range(1, n + 1):
        for j in range(1, i + 1):
            for k in range(1, j + 1):
                x += 1
    return x


inputs = [10,11,12]
for n in inputs:
    print(f"n = {n} returns x = {som3(n)}")