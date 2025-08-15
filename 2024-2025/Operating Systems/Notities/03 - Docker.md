# Docker

- [Docker](#docker)
  - [Van bare metal naar containers](#van-bare-metal-naar-containers)
    - [Bare metal](#bare-metal)
    - [Virtualisatie](#virtualisatie)
    - [Containerisatie](#containerisatie)
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

Start altijd met een Dockerfile, die ga je builden (= **image**). <br> Als je de image uitvoert, spreken we van een **container**.

DockerHub is een centrale repository op het internet met verschillende Dockerfiles.

## Docker Compose

Om Docker netwerken beter te beheren, gebruik je Docker Compose.

Config gebeurt in docker-compose.yml, dus niet meer op CLI.<br> Alle containers in de YAML-file kunnen makkelijk met één commando gestart en gestopt worden.

| Taak                             | Commando                                              |
| -------------------------------- | ----------------------------------------------------- |
| Containers starten               | `docker compose up`                                   |
| Containers stoppen               | `docker compose down`                                 |
| Draaiende compose projecten zien | `docker compose ls`                                   |
| Gebruikte images weergeven       | `docker compose images`                               |
| Lijst draaiende containers       | `docker compose ps` optie -a voor gestopte containers |

De containernaam is de naam van de service die je geeft in het docker-compose.yml bestand. Docker-netwerken hebben een ingebouwde DNS, je hoeft geen IP-adressen te gebruiken.

Een van de voordelen van Docker-netwerken is dat je databases ontoegankelijk maakt voor buitenaf. Dit is belangrijk om volgende redenen:

- Beveiliging: Minder kans op datalekken of gegevensverlies. Enkel de website heeft toegang tot de database.
- Beperken van netwerkverkeer: Verbetert de prestaties

Door de database op een local network te zetten met de website in Docker Compose, is de database van de buitenwereld afgeschermd.

-> Probeer nooit localhost te gebruiken in docker-compose.yml
