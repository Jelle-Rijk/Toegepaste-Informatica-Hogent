class BinaryHeap:

    def __init__(self, max_size=10):
        self.max_size = max_size
        self.elements = []


    def is_empty(self):
        return len(self.elements) == 0

    
    def get_min_elem(self):
        return self.elements[0]

    def insert_elem(self, item):
        self.elements.append(item)

    def remove_min_elem(self):
        min_elem = self.elements.pop(0)

    def __str__(self):
        return self.elements.__str__()