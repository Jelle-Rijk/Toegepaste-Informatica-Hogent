def zoek_binair(zoekItem,rij):
    l = 0
    r = len(rij) - 1

    while l != r:
        print(l)
        print(r)
        m = (l + r) // 2
        
        if rij[m] > zoekItem:
            r = m
        else:
            l = m + 1
    
    return l if rij[l] == zoekItem else -1