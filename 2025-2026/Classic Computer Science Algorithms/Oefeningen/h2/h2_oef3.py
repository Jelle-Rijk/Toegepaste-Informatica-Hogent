class DubbelGelinkteLijst:
    def __init__(self):
        self.eerste = self.KnoopDubbel() # Anchorelement vooraan
        self.laatste = self.KnoopDubbel() # Anchorelement achteraan
        self.eerste.volgende = self.laatste
        self.laatste.vorige = self.eerste

    def __str__(self):
        str = "DubbelGelinkteLijst:"
        knoop = self.eerste.volgende
        while knoop != None and knoop != self.laatste:
            str += f" {knoop.data}"
            knoop = knoop.volgende
        return str
    
    def verwijder(self, ref):
        'Verwijdert de Knoop na ref en return het data-veld'
        x = ref.volgende.data
        ref.volgende = ref.volgende.volgende
        return x
    
    def voeg_toe_voor(self, ref, element):
        'Voegt een nieuwe Knoop toe voor ref met data-veld x'
        nieuwe_knoop = self.KnoopDubbel()
        nieuwe_knoop.data = element

        nieuwe_knoop.volgende = ref
        nieuwe_knoop.vorige = ref.vorige
        ref.vorige = nieuwe_knoop
        nieuwe_knoop.vorige.volgende = nieuwe_knoop        


    def voeg_toe_na(self, ref, element):
        'Voegt een nieuwe Knoop toe na ref met data-veld x'
        nieuwe_knoop = self.KnoopDubbel()
        nieuwe_knoop.data = element
       
        nieuwe_knoop.vorige = ref
        nieuwe_knoop.volgende = ref.volgende
        ref.volgende = nieuwe_knoop
        nieuwe_knoop.volgende.vorige = nieuwe_knoop
    
    def zoek(self, x):
        'Returnt de eerste knoop met element x als data-veld'
        ref = self.eerste
        while ref != None and ref.data != x:
            ref = ref.volgende
        
        if ref == None:
            assert("Knoop niet gevonden")
        return ref
    

    class KnoopDubbel:
        def __init__(self):
            self.data = None
            self.volgende = None
            self.vorige = None
        
        def __str__(self):
            return str(self.data)
        
dd_list = DubbelGelinkteLijst()
ref = dd_list.zoek(None)
dd_list.voeg_toe_na(ref, 1)

ref = dd_list.zoek(1)
dd_list.voeg_toe_na(ref, 25)
dd_list.voeg_toe_voor(ref, 13)

print(dd_list)