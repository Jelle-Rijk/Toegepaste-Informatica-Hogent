# Docker

- [Van bare metal naar containers](#van-bare-metal-naar-containers)
- [Docker](#docker-1)
- [Docker Compose](#docker-compose)

## Van bare metal naar containers

**Bare metal -> virtualisatie -> containerisatie** 

### Bare metal
Nadelen van bare metal:
- Files en directories verspreid over verschillende plaatsen
- Moeilijk om meerdere versies van zelfde software te draaien
- Als de OS of een programma crasht, is er een kans dat alles crasht
- Sterke koppeling soft-hardware
- Meer fysieke ruimte en elektriciteit nodig
- **Onderbenutting van middelen** = mislopen van inkomsten

### Virtualisatie
Voordelen:
- Benut veel meer middelen
- Programma's van verschillende OS kunnen op hetzelfde systeem draaien.
- Elke filesystem kan zijn eigen rechten krijgen

Nadelen:
- Veel overhead (want 1 OS per app)
- VM's maken kost tijd
- Gebruikt veel schijfruimte (meestal door OS)
- Complex

### Containerisatie

Containers = afgeschermde omgevingen waarin 1 applicatie wordt uitgevoerd

I.p.v. hypervisor gebruik je een container runtime. De deployment is identiek aan een type 2 hypervisor.

Voordelen:
- Veel minder overhead

## Docker

Start altijd met een Dockerfile, die ga je builden (= image). <br> Als je de image uitvoert, spreken we van een **container**.


## Docker Compose