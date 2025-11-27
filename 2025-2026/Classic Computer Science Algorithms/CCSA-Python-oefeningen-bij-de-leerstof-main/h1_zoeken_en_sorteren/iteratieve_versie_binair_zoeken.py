def zoek_binair(zoekItem, rij):
    links = 0
    rechts = len(rij) - 1

    while links != rechts:
        print(f"{links}, {rechts}")
        midden = (links + rechts) // 2

        if zoekItem > rij[midden]:
            # zoek rechts
            links = midden + 1
        else:
            # zoek links
            rechts = midden
            
    return links if rij[links] == zoekItem else -1