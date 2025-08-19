1. Bij welke bestandstechniek is er geen mogelijkheid tot random access?

[] Contiguous storage
[] File allocation table
[x] Linked lists
[] Index nodes

2. Zijn de volgende uitspraken over persistente opslag juist of fout?

|                                                                                                               | Juist | Fout |
| ------------------------------------------------------------------------------------------------------------- | ----- | ---- |
| Bij het opzetten van een server zijn HDD's soms nog te verkiezen boven SSD's omdat HDD's betrouwbaarder zijn. |       | X    |
| Wanneer het doelbestand bij een hard link verwijderd wordt, is die link onbruikbaar.                          |       | X    |
| Wanneer het doelbestand bij een soft link verwijderd wordt, is die link onbruikbaar.                          | X     |      |

3. Zijn de volgende uitspraken over bestandssystemen juist of fout?

   |                                                                                                    | Juist | Fout |
   | -------------------------------------------------------------------------------------------------- | ----- | ---- |
   | Een Master Boot Record kan slechts vier primarie partities hebben                                  | X     |      |
   | Het commando mount op Linux past je Virtual File System aan                                        | X     |      |
   | Index nodes zijn een alternatief voor een file allocation table maar hebben een hoger Ram-verbruik |       | X    |
   | Het gebruik van een journal verhoogt de schrijfsnelheid van een bestandssysteem                    |       | X    |

4. a. Waar maakt een proces op een UNIX-systeem gebruik van als het een bestandssysteem wil aanspreken?

b. Lweg dit begrip kort uit, leg ook uit waarom dit nuttig is.

c. Hoe heten de bewerkingen van een bestandssysteem inladen en uitladen op een UNIX-systeem

Bestandssysteem inladen = mount <br>
Bestandssysteem uitladen = unmount

5. Zijn de volgende uitspraken over bestanden juist of fout?

|                                                                                                                     | Juist | Fout |
| ------------------------------------------------------------------------------------------------------------------- | ----- | ---- |
| Op een USB-stick die geformatteerd werd met exFAT kunnen bestanden groter dan 4GB geplaatst worden                  | X     |      |
| Op Windows geldt de regel "everything is a file"                                                                    |       | X    |
| Elk opslagmedium moet over minstens één bootable partitie beschikken.                                               |       | X    |
| Een virtual file system is een bestandssysteem om bestanden die niet op een fysiek opslagmedium staan te benaderen. |       | X    |

6. a. Wat is de hoofdreden om journaling te gebruiken? Leg kort uit.

Journaling voorkomt corruptie wanneer het systeem onverwacht uitschakelt tijdens een schrijfbewerking.

b. Leg kort uit hoe journaling werkt.

Wanneer het OS een schrijfbewerking wil doen, schrijft het deze neer in een journal alvorens dit uit te voeren. Als het systeem dan onverwachts uitgeschakeld wordt, kan het de onafgewerkte bewerkingen in het journal alsnog afwerken.

7. Welke van onderstaande zaken worden op Linux niet voorgesteld als files?

[] Soft Links
[] Directories
[] File Systems
[X] Sockets

8. Wat is het verschil tussen een hard link en een soft link?

[] Wanneer het doelbestand in een andere map geplaatst wordt, zal de soft link nog correct werken, maar de hard link niet meer. <br>
[] Een hard link gebruikt altijd een relatief pad en een soft link een absoluut pad. <br>
[X] Wanneer het doelbestand hernoemd wordt, zal de hard link nog correct werken, maar de soft link niet meer. <br>
[]Een hard link gebruikt altijd een absoluut pad en een soft link een relatief pad.

9. Welk bestandssysteem is ontworpen voor optische schijven (zoals CD's en DVD's)?

[] BTRFS
[] Ext4
[X] UDF
[] ZDF

10. Wat is geen voordeel van het gebruik van contiguous storage voor bestanden.

[] Het biedt een goede leesperformantie. <br>
[] Het ondersteunt random access <br>
[X] Het vermijdt fragmentatie <br>
[] Geen van bovenstaande

11. Welke statusovergang is er niet mogelijk bij een proces?

[X] New -> Blocked <br>
[] Blocked -> Suspend <br>
[] Blocked -> Ready <br>
[] Suspend -> Ready

12. Welke van onderstaande scheduling algoritmes zijn preemptive?

|      | Juist | Fout |
| ---- | ----- | ---- |
| SPN  |       | X    |
| RR   | X     |      |
| FCFS |       | X    |
| FIFO |       | X    |

13. Zijn de volgende uitspraken over scheduling juist of fout?

|                                                                                                                   | Juist | Fout |
| ----------------------------------------------------------------------------------------------------------------- | ----- | ---- |
| SPN en SRT hebben altijd hetzelfde resultaat als processen op steeds verschillende tijdstippen worden aangeboden. |       | X    |
| SPN is een voorbeeld van een non preemptive scheduler                                                             | X     |      |
| Bij een preemptive scheduler worden steeds korte processen bevoordeeld.                                           |       | X    |
| Je hebt geen scheduler nodig als je niet met multiprogramming werkt.                                              |       | X    |

14. Als we het hebben over de process image, dan bedoelen we...

[] het gedeelte in het RAM dat onder meer de instructies bevat. <br>
[] het (uitvoerbare) bestand gegenereerd door een compiler <br>
[X] het element in de process table dat alle informatie over een proces bevat <br>
[] de deamon met PID = 1 die alle andere processen beheert.

15. Welke toestandsovergang is niet mogelijk voor een proces?

[X] Blocked -> Running <br>
[] Suspended -> Ready<br>
[] Running -> Exit<br>
[] Ready -> Running<br>

16. Sorteer van snelst naar traagst op gebied van leessnelheid. Plaats het snelste medium bovenaan en het traagste onderaan.

_Internet, SSD, RAM-geheugen, HDD_

RAM-geheugen <br> SSD <br> HDD <br> Internet

17. Wat is een ander woord voor "deamon"?

[] Deadlock <br>[X] Service <br>[] Batch-proces <br>[] Foreground process

18. Verbind het begrip met de juiste uitleg.

| Uitleg                                                                                              | Begrip          |
| --------------------------------------------------------------------------------------------------- | --------------- |
| De tijd dat een proces in het systeem aanwezig is maar niet uitgevoerd wordt.                       | Wachttijd       |
| De tijd dat een proces in het systeem aanwezig is vanaf het aanbieden tot effectief afgewerkt zijn. | Turnaround time |
| Bepaalde processen krijgen nooit CPU tijd.                                                          | Starvation      |
| Een scheduler mag lopende processen onderbreken.                                                    | Preemptive      |

19. Welke uitspraak over scheduling is fout?

[] Een preemptive scheduling algoritme kan een ander proces CPU-tijd geven vooraleer het huidige proces volledig is uitgevoerd. <br>
[] Starvation treedt op wanneer een proces nooit CPU-tijd krijgt doordat het algoritme steeds voorrang geeft aan andere processen. <br>
[X] Bij een non-preemptive scheduling algoritme kan geen monopolisering optreden.<br>
[] Wanneer een proces de CPU moet vrijgeven ten voordele van een ander proces, wordt de procesinformatie van het eerste proces weggeschreven en de procesinformatie van het andere proces ingeladen. Dit heet een context switch.

20. Welke uitspraak is fout?

[] Een interrupt is het gevolg van een bepaald event (vb. detectie van nieuwe hardware). <br>
[] Een interrupt onderbreekt de uitvoering van een programma op de CPU om de instructies van de interrupt handler te kunnen uitvoeren. <br>
[X] Een interrupt kan de instructiecyclus onderbreken tussen fetch en execute. <br>
[] Een interrupt veroorzaakt een context switch van het huidige programma naar de interrupt handler.

21. <strong>In de cursus zagen we 4 mogelijkheden om deadlocks te behandelen. </strong>

a. Wat is het verschil tussen het voorkomen het vermijden van deadlocks?

Als je deadlocks voorkomt zorg je ervoor dat één van de vier voorwaarden waaraan voldaan moet worden om een deadlock te krijgen niet voor kan komen. Je neemt als het ware de mogelijkheid weg om een deadlock te krijgen.

Als je deadlocks vermijdt, checkt de OS of een bepaald verzoek tot een deadlock kan leiden. Als de OS vermoedt dat dit het geval is, wordt het verzoek geweigerd.

b. Hoe kan de OS achterhalen dat er een deadlock opgetreden is.

De OS kan dit op verschillende manieren doen. Als een proces lang in de blocked state verkeert, wijst dit erop dat er een deadlock opgetreden is. De OS kan ook in de Resource Allocation Graph kijken of het een cyclus detecteert. Als dat zo is, is er een deadlock.

22. Welk fenomeen is te zien in onderstaande figuur? Px stelt een proces voor, Rx stelt een resource voor.

![Figuur](./img/Oefenexamen%20vraag%2022.png)

[X] Deadlock [] Swapping [] Starvation [] Round Robin

23. Wat is het verschil tussen parallel concurrent execution en parallellisme?

Bij parallel concurrent execution worden twee taken tegelijkertijd op verschillende cores / systemen uitgevoerd. Bij parallellisme wordt een taak opgesplitst in kleinere deeltaken. Deze kunnen daarna concurrent of parallel uitgevoerd worden.

24. Het algoritme van Peterson kan gebruikt worden om...

[] deadlocks te vermijden <br>
[] deadlocks te signaleren <br>
[] synchronisatie tussen processen te implementeren <br>
[X] wederzijdse uitsluiting af te dwingen

25. Een bestandssynchronisatie waarbij alle wijzigingen aan de bron worden doorgevoerd naar het doel, maar niet omgekeerd, heet...

[] mirror [] contribute [X] echo [] synchronize

26. <br> ![Figuur](./img/Oefenexamen%20vraag%2026.png)

a. Wat is de theoretische snelheidswinst die kan behaald worden voor een programma als je beschikt over 9 CPU cores en 60% van het programma niet versneld kan worden?

1.55

b. Wat is de maximale snelheidswinst in dit geval mocht je beschikken over een oneindig aantal CPU cores in plaats van 9?

1.67

27.

a. Je ontwikkelt een Java FX applicatie. De applicatie maakt gebruik van MySQL-queries op een databank. Tijdens het ophalen van de data hapert telkens de UI maar uiteindelijk verschijnt de data wel, hoe komt dit?

Het lijkt erop dat zowel de JavaFX UI als de queries op dezelfde thread gebeuren. Dat betekent dat de UI niet verder berekend kan worden terwijl de queries hun antwoord van de MySQL-server halen.

b. Wat kan je doen om dit probleem te verhelpen?

Je kan de GUI en de queries op een verschillende thread zetten. Zo kan de UI verder berekend worden terwijl de query-thread op een antwoord wacht.

28. Welke uitspraak over processen en threads is correct?

[] Elke thread beschikt zelf over ruimte om zijn instructies bij te houden. <br>
[] Er is maar één program counter die gedeeld is over alle threads van een proces. <br>
[X] Threads binnen één proces kunnen aan elkaars gegevens zonder enige beperking. <br>
[] Threads houden zelf geen toestand bij, dit gebeurt enkel voor processen.

29. De wet van Amdahl...

[X] houdt rekening met het feit dat een deel van het programma niet versneld kan worden door meer CPU cores toe te voegen. <br>
[] is niet bruikbaar voor een (theoretisch) oneindig aantal CPU cores <br>
[] leert ons dat een multi-threaded programma dubbel zo snel wordt als we het aantal cores verdubbelen <br>
[] is niet bruikbaar voor een single-threaded proces

30. a. Welk type hypervisor is Oracle VirtualBox?

Type 2

b. Wat zijn de eigenschappen van dit type hypervisor?

Deze hypervisor moet op een OS draaien. Dat betekent dat deze niet bare metal kan draaien en dat je het hostapparaat ook voor andere zaken naast het draaien van VM's kan gebruiken.

31. Zijn de volgende uitspraken over cloud computing en virtualisatie juist of fout?

|                                                                                 | Juist | Fout |
| ------------------------------------------------------------------------------- | ----- | ---- |
| Multi-Tenancy is enkel mogelijk binnen Cloud Computing                          |       | X    |
| Bij Cloud Computing hebben we een quasi oneindig aantal bronnen ter beschikking |       | X    |
| Een Type 1 hypervisor werkt rechtstreeks bovenop de hardware                    | X     |      |
| Oracle VirtualBox is een applicatie-specifieke hypervisor                       |       | X    |

32. a. Wat wordt bedoeld met de elasticiteit van de cloud?

Hiermee wordt bedoeld dat je de gehuurde resources die je nodig hebt makkelijk kan op- en neerschalen naar gelang het gebruik.

b. Welke problemen in verband met provisioning kunnen dankzij elasticiteit opgelost worden?

Je kan tijdens piekmomenten meer resources huren. Zo hoef je niet permanent meer te betalen en kan je terug neerschalen als de piek voorbij is.

33. Panopto is een voorbeeld van:

[] PaaS [] FaaS [X] SaaS [] IaaS

34. Op een Windows toestel draaien enkele VM's bovenop Hyper-V. De gebruiker van het toestel heeft daarnaast ook Oracle VirtualBox geïnstalleerd, maar merkt dat hij geen virtuele machines kan opstarten. Hoe komt dit?

Hyper-V is een type 1 hypervisor. Type 2 hypervisors zoals VirtualBox kunnen geen VM's draaien als er al een type 1 actief is.

35. Welke uitspraak is niet waar?

[] Een Docker container is het resultaat van docker run op basis van een Docker image. <br>
[] Een Docker image kan voortbouwen op een andere Docker image. <br>
[X] Bij iedere Dockerfile hoort slechts één Docker container.<br>
[] Een Docker image is het resultaat van docker build op basis van een Dockerfile.

36. Plaats de marker op de correct plaats in het schema van Docker commando's.

1 - Container <br>
2 - Image <br>
3 - Dockerfile <br>
4 - Registry (vb. Docker Hub)

![Schema van Docker commando's](./img/Oefenexamen%20vraag%2036.png)

37. Waarom zie je soms optie `-d` bij het commando `docker compose up`?

[] De volumes worden afgeschermd van de containers door deze readonly te maken. <br>
[] De containers worden automatisch herstart na een crash. <br>
[] Bij het ingeven van CTRL+C worden de containers niet stopgezet.<br>
[] Bij het uitloggen worden de containers niet stopgezet.<br>
[X] De terminal blijft beschikbaar voor andere opdrachten. <br>
[] De containers worden verwijderd na het stoppen.

38. Op ons toestel lopen er op dit moment geen andere docker containers. We voeren volgende commando's uit:

```bash
docker compose up
docker compose down
docker compose ps
docker compose ps -a
```

Welke uitspraken zijn waar als we ervan uitgaan dat er geen errors zijn opgetreden bij commando 1 en 2?

[X] docker compose ps -a toont de uitgevoerde containers <br>
[] docker compose ps toont de uitgevoerde containers<br>
[] de -a optie bestaat niet en geeft een fout<br>

1.  Wat is geen voorbeeld van een besturingssysteem?

[] Ubuntu<br> [X] Docker<br> [] MS-DOS<br> [] Unix

40.

![Processen](./img/Oefenexamen%20vraag%2040.png)

a. Hoe ziet de planning eruit wanneer gebruik gemaakt wordt van FCFS?

| 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   | 10  | 11  | 12  | 13  | 14  | 15  |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| A   | A   | A   | B   | B   | C   | C   | D   | D   | D   | D   | E   | E   | E   | E   | E   |

b. Hoe ziet de planning eruit wanneer gebruik gemaakt wordt van RR (Q = 2)?

| 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   | 10  | 11  | 12  | 13  | 14  | 15  |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| A   | A   | B   | B   | C   | C   | D   | D   | A   | E   | E   | D   | D   | E   | E   | E   |
