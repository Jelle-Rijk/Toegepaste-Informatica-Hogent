def selection_sort_vooraan(a):
    for aantal_gesorteerd in range(0, len(a) - 1):
        min = aantal_gesorteerd
        
        # zoek minimum
        for i in range(aantal_gesorteerd, len(a)):
            if a[i] < a[min]:
                min = i

        # swap
        temp = a[aantal_gesorteerd]
        a[aantal_gesorteerd] = a[min]
        a[min] = temp

        print(a)


if __name__ == "__main__":
    a = [int(_) for _ in input().split()]
    selection_sort_vooraan(a)

