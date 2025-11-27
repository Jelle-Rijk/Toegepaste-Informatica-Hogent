import random

def bubble_sort(a):
    n = len(a)
    aantal_controles = 0
    for i in range(0, n - 1): # loop door de array
        for j in range(n - 1, i, -1):
            if a[j - 1] > a[j]:
                temp = a[j]
                a[j] = a[j-1]
                a[j-1] = temp
            aantal_controles += 1
        print(a)
    
    print(f"Voor een rij van lengte {n} werd het if-statement {aantal_controles} keer uitgevoerd")

array_length = 64
a = [13,7,8,1]
bubble_sort(a)

if __name__ == "__main__":
    a = [int(_) for _ in input().split()]
    bubble_sort(a)