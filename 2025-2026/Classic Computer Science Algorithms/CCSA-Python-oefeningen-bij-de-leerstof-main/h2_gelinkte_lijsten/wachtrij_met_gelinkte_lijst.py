class QueueList:

    class Knoop:

        def __init__(self,data=None,volgende=None) -> None:
            self.data = data
            self.volgende = volgende


    def __init__(self) -> None:
        self.kop = None
        self.staart = None

    def is_empty(self):
        return self.kop == None

    def enqueue(self,data):
        nieuwe_knoop = self.Knoop(data)
        if self.is_empty():
            self.kop = self.staart = nieuwe_knoop
        else:
            self.staart.volgende = nieuwe_knoop
            self.staart = nieuwe_knoop

    def front(self):
        return self.kop.data

    def dequeue(self):
        data = self.kop.data
        self.kop = self.kop.volgende
        return data
    
    def invert(self):
        huidige_knoop = self.kop
        vorige_knoop = None

        while huidige_knoop != None:
            volgende_knoop = huidige_knoop.volgende
            huidige_knoop.volgende = vorige_knoop
            
            vorige_knoop = huidige_knoop
            huidige_knoop = volgende_knoop
        
        self.staart = self.kop
        self.kop = vorige_knoop