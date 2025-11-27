class GelinkteLijst:
    def __init__(self):
        self.eerste = self.Knoop() # Anchorelement (OEFENING 2.1)

    def __str__(self):
        str = "GelinkteLijst:"
        knoop = self.eerste.volgende
        while knoop != None:
            str += f" {knoop.data}"
            knoop = knoop.volgende
        return str

    
    def zoek(self, x):
        'Zoekt eerste voorkomen van x'
        ref = self.eerste
        while ref != None and not ref.data == x:
            ref = ref.volgende
        return ref
    
    def verwijder(self, ref):
        'Verwijdert de knoop na ref en returnt de data ervan'
        x = ref.volgende.data
        ref.volgende = ref.volgende.volgende
        return x
    
    def voeg_toe(self, ref, x):
        'Voegt knoop toe na ref met data-veld x'
        nieuwe_knoop = self.Knoop()
        nieuwe_knoop.data = x
        nieuwe_knoop.volgende = ref.volgende
        ref.volgende = nieuwe_knoop

    # OEFENING 1
    def size(self):
        size = 0
        huidige_knoop = self.eerste
        while huidige_knoop.volgende != None:
            size += 1
            huidige_knoop = huidige_knoop.volgende
        return 
    
    # OEFENING 2.2
    def invert(self):
        omgekeerd = GelinkteLijst()
        huidige_knoop = self.eerste.volgende
        while huidige_knoop != None:
            omgekeerd.voeg_toe(omgekeerd.eerste, huidige_knoop)
            huidige_knoop = huidige_knoop.volgende
        return omgekeerd

    class Knoop:
        def __init__(self):
            self.data = None
            self.volgende = None
        
        def __str__(self):
            return str(self.data)
        


linked_list = GelinkteLijst()
element = linked_list.zoek(None)
linked_list.voeg_toe(element, 6)

element = linked_list.zoek(6)
linked_list.voeg_toe(element, 13)

element = linked_list.zoek(13)
linked_list.voeg_toe(element, 7)

element = linked_list.zoek(7)
linked_list.voeg_toe(element, 42)

element = linked_list.zoek(42)
linked_list.voeg_toe(element, 16)

element = linked_list.zoek(7)
linked_list.voeg_toe(element, 22)


size = linked_list.size()
print(size)

omgekeerde_list = linked_list.invert()

print(linked_list)
print(omgekeerde_list)