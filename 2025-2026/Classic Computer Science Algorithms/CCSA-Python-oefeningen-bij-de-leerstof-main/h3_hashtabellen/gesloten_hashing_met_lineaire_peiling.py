class HashSet:

    def __init__(self, max_size=10):
        self.max_size = max_size
        self.collectie = [None] * self.max_size
        self.flag = "V"

    def add(self, item):
        start_index = hash(item) % self.max_size
        
        if None not in self.collectie:
            raise ValueError("Collectie is vol")
        if item in self.collectie:
            return -1
        
        for offset in range(0, self.max_size):
            index = start_index + offset % self.max_size
            print(index)
            if self.collectie[index] == None or self.collectie[index] == self.flag:
                self.collectie[index] = item
                return index


    def index_of(self, item):
        start_index = hash(item) % self.max_size

        for offset in range(0, self.max_size):
            index = start_index + offset % self.max_size
            element = self.collectie[index]
            print(index)
            if element == item:
                return index
            elif element == None:
                return -1
        return -1

    def delete(self, item):
        index = self.index_of(item)
        if index == -1:
            return False
        self.collectie[index] = self.flag
        return True


    





