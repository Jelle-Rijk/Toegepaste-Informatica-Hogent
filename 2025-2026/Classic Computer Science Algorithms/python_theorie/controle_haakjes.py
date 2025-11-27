class Stack:
    def __init__(self):
        self.t = None
    
    def isEmpty(self):
        return self.t == None
    
    def push(self, x):
        new_node = self.Node()
        new_node.data = x
        new_node.next = self.t
        self.t = new_node
    
    def pop(self):
        x = self.t.data
        self.t = self.t.next
        return x
    
    def peek(self):
        return self.t.data



    # Inner Node Class
    class Node:
        def __init__(self):
            self.data = None
            self.next = None

corresponderende_haakjes = {"(": ")", "[": "]", "{": "}"}

def controleer_haakjes(uitdrukking):
    s = Stack()

    for i in range(0, len(uitdrukking)):
        symbool = uitdrukking[i]

        if symbool in "([{":
            s.push(symbool)
        elif symbool in ")]}":
            if s.isEmpty():
                print("Te veel sluit symbolen")
            else:
                voorgaand = s.pop()
                if symbool != corresponderende_haakjes[voorgaand]:
                    print(f"Fout symbool: {symbool}")
    
    if not s.isEmpty():
        print("Te veel open symbolen.")
