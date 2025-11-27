import random

def merge_sort(arr):
    merge_sort_recursive(arr, 0, len(arr) - 1)
    return arr

def merge_sort_recursive(arr, begin, eind):
    if begin == eind: 
        print(f"Hit base case: {arr[begin]} at index {begin} -> arr = {arr}\n") # er is maar 1 element = gesorteerd
        return
    
    midden = (begin + eind) // 2
    merge_sort_recursive(arr, begin, midden) # sorteer linkerhelft
    merge_sort_recursive(arr, midden + 1, eind) # sorteer rechterhelft
    merge(arr, begin, midden, eind) # voeg de gesorteerde helften samen


def merge(arr, begin, midden, eind):
    linkerindex = begin
    rechterindex = midden + 1
    hulprij = [0 for x in range(0, len(arr))]
    hulpindex = begin

    while linkerindex <= midden and rechterindex <= eind:
        if arr[linkerindex] <= arr[rechterindex]:
            hulprij[hulpindex] = arr[linkerindex]
            linkerindex += 1
        else:
            hulprij[hulpindex] = arr[rechterindex]
            rechterindex += 1
        hulpindex += 1
    
    if linkerindex > midden:
        while rechterindex <= eind:
            hulprij[hulpindex] = arr[rechterindex]
            rechterindex += 1
            hulpindex += 1
    else:
        while linkerindex <= midden:
            hulprij[hulpindex] = arr[linkerindex]
            linkerindex += 1
            hulpindex += 1
    
    for k in range(begin, eind + 1):
        arr[k] = hulprij[k]
    print(f"Variables: begin = {begin}, midden = {midden}, eind = {eind}\nMerged arrays: {arr[begin:midden+1]} AND {arr[midden+1:eind+1]} \nMerged array: {arr[begin:eind+1]} \nArray: {arr}\n")


array_length = 10
input = [random.randint(-65535, 65535) for x in range(0, array_length)]
original_input = input.copy()

output = merge_sort(input)
print(f"Input = {original_input} \nOutput = {output}")
