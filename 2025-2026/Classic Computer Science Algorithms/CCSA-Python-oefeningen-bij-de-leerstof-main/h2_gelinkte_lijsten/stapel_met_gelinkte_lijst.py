class StackList:

    class Knoop:
        def __init__(self, data=None, volgende=None):
            self.data = data
            self.volgende = volgende

    def __init__(self):
        self.top = None

    def is_empty(self):
        return self.top == None

    def push(self, data):
        self.top = self.Knoop(data, self.top)

    def peek(self):
        return self.top.data

    def pop(self):
        data = self.top.data
        self.top = self.top.volgende
        return data
        



    