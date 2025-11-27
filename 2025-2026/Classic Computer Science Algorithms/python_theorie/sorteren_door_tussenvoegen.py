import random

def insertion_sort(arr):
    for i in range(1, len(arr)):
        huidig_element = arr[i]
        huidige_index = i

        while (huidige_index > 0 and arr[huidige_index - 1] > huidig_element):
            arr[huidige_index] = arr[huidige_index - 1]
            huidige_index -= 1
        arr[huidige_index] = huidig_element
        print(f"Moved {huidig_element} from index {i} to index {huidige_index} -> {arr}" if huidige_index != i else f"{huidig_element} at index {huidige_index} was already sorted -> {arr}")

array_length = 10
input = [random.randint(-65535, 65535) for x in range(0, array_length)]
print(f"INPUT:  {input}")
insertion_sort(input)
print(f"OUTPUT: {input}")
