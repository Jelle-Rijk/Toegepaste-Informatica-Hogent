| Omschrijving                                                 | Commando Windows (PowerShell)                                   |
| ------------------------------------------------------------ | --------------------------------------------------------------- |
| Overzicht alle processen                                     | Get-Process                                                     |
| Overzicht processen per gebruiker                            | <strong>.\Get-UserProcess.ps1 </strong>                         |
| Overzicht details van een proces                             | Get-Process -Id <procesid>                                      |
| Overzicht processtructuur                                    | .<strong>\Get-ProcessTree.ps1 </strong>                         |
| Overzicht alle actieve processen met automatische verversing | <strong>.\Get-ProcessTop.ps1 </strong>                          |
| Id van proces zoeken                                         | (Get-Process -Name <procesnaam>).Id                             |
| Proces stopzetten                                            | Stop-Process <id>                                               |
| Proces laten wachten                                         | Start-Sleep <seconden>                                          |
| Proces op achtergrond starten                                | Start-Process -NoNewWindow <commando> Start-Job { \<commando> } |

De vetgedrukte commando's verwijzen naar de scripts in [scripts.zip](./scripts.zip), het zijn geen standaardcommando's.
