# Application Layer

## Application, Presentation and Session

De applicatie-, presentatie- en sessielagen uit het OSI-model komen overeen met de Applicatielaag in het TCP/IP-model. Hieronder gaan we uit van het OSI-model.

### Applicatielaag

Laag die het dichtst bij de eindgebruiker staat.

Protocollen op deze laag:

| Naam                                    | TCP / UDP  | Poort                    | Gebruik                                                              |
| --------------------------------------- | ---------- | ------------------------ | -------------------------------------------------------------------- |
| DNS                                     | TCP of UDP | 53                       | Domeinnamen naar IPs vertalen                                        |
| BOOTP (Bootstrap Protocol)              | UDP        | 68 (client), 67 (server) | Workstation zijn eigen IP laten ontdekken (vervangen door DHCP)      |
| DHCP                                    | UDP        | 68 (client), 67 (server) | Dynamisch toewijzen van IP adressen                                  |
| SMTP (Simple Mail Transfer Protocol)    | TCP        | 25                       | Mails van clients naar servers en tussen servers onderling verzenden |
| POP3 (Post Office Protocol)             | TCP        | 110                      | Mails in een e-mail client downloaden van een e-mail server          |
| IMAP (Internet Message Access Protocol) | TCP        | 143                      | Mails bekijken op een e-mail server                                  |
| FTP                                     | TCP        | 20 en 21                 | Files verzenden over een netwerk                                     |
| TFTP (Trivial File Transfer Protocol)   | UDP        | 69                       | Zelfde als FTP, minder overhead maar minder reliable                 |
| HTTP                                    | TCP        | 80 en 8080               | Webpagina's / video / tekst / afbeeldingen over het web              |
| HHTPS                                   | TCP of UDP | 443                      | Zelfde als HTTP maar met encryptie                                   |

### Presentatielaag

Drie functies:

- Data bij de source formatteren zodat de data bruikbaar is bij de destination.
- Data compressen en decompressen
- Data encrypten en decrypten

Hier worden ook standaard file formats gezet (vb. .jpeg, .gif, .mov, .png, .mp3)

### Sessielaag

Deze laag is verantwoordelijk voor het creëren en onderhouden van sessies.

## Peer-to-Peer

## Web and Email Protocols

## IP Addressing Services

## File Sharing Services
