from collections import deque # wachtrij in Python 

def precies_een_verschillend(woord1,woord2) -> bool:
    if len(woord1) != len(woord2): return False

    verschillen = 0
    for index in range(len(woord1)):
        if woord1[index] != woord2[index]:
            verschillen += 1
        if verschillen > 1: return False

    return verschillen == 1        
    
def maak_graaf(woorden) -> dict:
    graaf = {}
    for woord in woorden:
        verwante_woorden = ({verwant_woord for verwant_woord in woorden if verwant_woord != woord and precies_een_verschillend(woord, verwant_woord)})
        graaf[woord] = verwante_woorden
    return graaf

def kortste_pad(graaf,woord) -> dict:
    voorgaande_knopen = {sleutel : None for sleutel in graaf.keys()}
    voorgaande_knopen[woord] = (woord)
    wachtrij = deque()
    wachtrij.append(woord)

    while len(wachtrij) != 0:
        huidige_knoop = wachtrij.popleft()
        for buur in sorted(graaf[huidige_knoop]):
            if voorgaande_knopen[buur] == None:
                voorgaande_knopen[buur] = huidige_knoop
                wachtrij.append(buur)
    return voorgaande_knopen

def geef_pad(voorgangers,woord) -> list:
    pad = [woord]
    huidig_woord = woord
    voorganger = voorgangers[huidig_woord]

    while huidig_woord != voorganger:
        pad.insert(0, voorganger)
        huidig_woord = voorganger
        voorganger = voorgangers[huidig_woord]
    return pad