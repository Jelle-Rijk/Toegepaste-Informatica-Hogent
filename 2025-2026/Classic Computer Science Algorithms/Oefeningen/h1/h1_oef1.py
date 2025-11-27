def zoek_binair(rij, zoek_item):
    l = 0
    r = len(rij) - 1

    while l < r:
        m = (l + r) // 2
        print(f"l = {l}, r = {r}, m = {m}\n{rij[l:m]} - {rij[m]} - {rij[m + 1:r]}")

        if rij[m] > zoek_item:
            r = m
        else:
            l = m + 1
            
    return l if rij[l] == zoek_item else -1


def zoek_waarde(waarde):
    rij = [1,2,3,4,6,7,8,9,10]
    index = zoek_binair(rij, waarde)
    print(f"Waarde {waarde} werd op index {index} teruggevonden.\n" if index != -1 else f"Waarde {waarde} stond niet in de lijst.\n")

zoek_waarde(3)
zoek_waarde(5)
zoek_waarde(10)