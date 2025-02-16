# Basic Switch and End Device Configuration

## IOS Access

Drie main methoden om toegang te krijgen tot een netwerk.

-	Console: Met een speciale kabel, hiermee krijg je altijd access, ook als de network configs nog niet ingesteld zijn.
-	SSH (= Secure Shell): Veilige manier om op afstand verbinding te maken met het netwerk.
-	Telnet: Onveilige manier om op afstand verbinding te maken met het netwerk. Enkel gebruiken in leeromgevingen.

Legacy manier: Sommige oude devices hebben een AUX-poort om verbinding te maken via een telefoonnetwerk. Dit werkt op dezelfde manier als een consoleverbinding.

## IOS navigatie
|Mode|Rechten|Symbool in prompt|
|----|-------|-----------------|
|User EXEC| Basiscommando's, "view-only mode"| > |
|Privileged EXEC | Alle commando's | # |

**Configuratie:**
-	Line Configuration Mode: voor Console, SSH, Telnet, Aux
-	Interface Configuration Mode: config van een port of router network interface

De configuratiemodus wordt tussen haakjes weergegeven voor de exec-modus.

Commando’s om modi te switchen
-	`enable` -> gaat van user EXEC naar privileged EXEC
-	`disable` -> gaat van privileged EXEC naar user EXEC
-	`configure terminal` / `config t`: Global configuration mode
-	`exit` (vanuit config mode): Ga terug naar vorige config mode
- `line [linetype] [number]`: line config voor die lijn
-	`end` / CTRL+Z: ga terug naar privileged EXEC mode
-	`interface [interfacenaam] [number]`: interface config

## Command Syntax
|Schrijfwijze|Betekenis|
|---|---|
|**bold**|letterlijk overnemen|
|*italic*| argumenten die je moet invullen|
|[x]|optioneel element of argument|
|{x}|	verplicht element of argument|
|[x{y\|z}]|verplichte keuze in een optioneel argument|

## Basic config
Naam geven aan een device -> <code>**hostname** *devicenaam*</code>

Beveiliging -> privileged EXEC, user EXEC en remote Telnet moeten altijd beveiligd zijn met sterke wachtwoorden Passwords plaatsen op user EXEC of virtuele terminals met “password password” en daarna “login”
- Password op privileged EXEC met <code>**enable secret** *password* </code> (vanuit global config)
- Passwords zijn unencrypted, zwakke encryptie kan automatisch met **`service password-encryption`**
-> Je kan checken of dit gewerkt heeft met **`show running-config`**

In sommige rechtssystemen is inbreken op devices enkel illegaal als er een banner is waarin staat dat je dit device niet mag gebruiken. Dit kan je instellen met <code>**banner motd** # *bericht* #</code>

## Save configs
Twee systeembestanden die de configs opslaan:
-	startup-config: Alle commando’s die runnen bij booten, blijft opgeslagen als het device uitstaat.
-	running-config: Huidige configuratie, opgeslagen in RAM-geheugen (verdwijnt dus als het apparaat uit gaat)

<code>**copy running-config startup-config**</code> -> kopieert de config naar de startup, zodat het apparaat de instellingen onthoudt

Om running-config changes te resetten naar wat opgeslagen is in de startup-config gebruik je <code>**reload**</code>

Startup-config kan geleegd worden met **`erase startup-config`** en **`reload`**.

**Reloaden start het apparaat opnieuw op (= downtime).**

- flash-memory: bevat het IOS
- nvram: bevat de startup-config
 
## IP Addressing
Om een ip-adres te geven aan een SVI (**Switch Virtual Interface**)
-	<code>**ip address** *ip-address subnet-mask*</code>
-	enablen met **`no shutdown`**
-	default gateway setten met <code>**ip default-gateway** *ip-address*</code>

> **Tip!**
>
> Als de verbinding slaagt in de ene richting, maar niet in de andere ligt het meestal aan de firewall settings.
