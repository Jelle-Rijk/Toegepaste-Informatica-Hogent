class Queue:
    def __init__(self):
        ' constructor, maakt een nieuwe wachtrij aan waarna de wachtrij bestaat als lege wachtrij'
        self.k = None
        self.s = None
    
    def __str__(self):
        str = "Queue:"
        huidige_knoop = self.k
        while huidige_knoop != None:
            str += f" {huidige_knoop}"
            huidige_knoop = huidige_knoop.volgende
        return str

    def is_empty(self):
        'controleert of een wachtrij al dan niet leeg is'
        return self.k == None

    def enqueue(self, x):
        'voegt een gegeven element toe aan de staart van een wachtrij'
        nieuwe_knoop = self.Knoop()
        nieuwe_knoop.data = x
        if self.is_empty():
            self.k = nieuwe_knoop
            self.s = nieuwe_knoop
        else:
            self.s.volgende = nieuwe_knoop
            self.s = nieuwe_knoop

    def dequeue(self):
        'verwijdert het element aan de kop in een wachtrij en retourneert het verwijderde element'
        if self.is_empty():
            raise AssertionError("Wachtrij is leeg.")
        element = self.k.data
        self.k = self.k.volgende
        return element

    def front(self):
        'retourneert het voorste element, m.a.w. de kop, van een wachtrij, zonder het te verwijderen'
        return self.k.data
    
    def invert(self):
        'draait de volgorde van de elementen in de queue om'
        huidige_knoop = self.k # A
        vorige_knoop = None
        
        while huidige_knoop != None:
            volgende_knoop = huidige_knoop.volgende
            huidige_knoop.volgende = vorige_knoop
            vorige_knoop = huidige_knoop
            huidige_knoop = volgende_knoop
        
        self.s = self.k
        self.k = vorige_knoop

    class Knoop():
        def __init__(self):
            self.data = None
            self.volgende = None
        
        def __str__(self):
            return str(self.data)

q = Queue()
q.enqueue(6)
q.enqueue(7)
q.enqueue(8)
q.enqueue(9)
q.enqueue(10)
q.enqueue(11)
q.enqueue(12)
print(q)
q.invert()
print(q)