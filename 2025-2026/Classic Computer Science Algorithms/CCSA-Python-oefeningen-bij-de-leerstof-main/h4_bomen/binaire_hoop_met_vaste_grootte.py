import math

class BinaryHeap:

    def __init__(self, max_size=10):
        pass

    def is_empty(self):
        pass
    
    def get_min_elem(self):
        pass

    def insert_elem(self, item):
        pass

    def remove_min_elem(self):
        pass


    def __str__(self):
        pass

b = BinaryHeap()
print(b.is_empty())
b.insert_elem(3)
print(b)
print(b.is_empty())
b.insert_elem(1)
b.insert_elem(2)
print(b)
print(b.remove_min_elem())
print(b)