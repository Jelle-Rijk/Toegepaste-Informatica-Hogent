# Basic Router Configuration

- [Initial Router Settings configureren](#initial-router-settings-configureren)
- [Interfaces configureren](#interfaces-configureren)
- [Default Gateway configureren](#default-gateway-configureren)

## Initial Router Settings configureren

| Taak                                           | Commando                                                                                               |
| ---------------------------------------------- | ------------------------------------------------------------------------------------------------------ |
| Device naam configureren                       | <code> hostname <i>hostname</i> </code>                                                                |
| Wachtwoord voor privileged EXEC mode instellen | <code> enable secret <i>password</i></code>                                                            |
| User EXEC mode beveiligen                      | <code> line console 0 <br> password <i>password</i> <br> login </code>                                 |
| Telnet / SSH beveiligen                        | <code> line vty 0 4 <br> password <i>password</i><br>login<br>transport input { ssh \| telnet} </code> |
| Wachtwoorden beveiligen                        | <code> exit <br> service-password-encryption</code>                                                    |
| Banner instellen                               | <code> banner motd <i>delimiter message delimiter</i> </code>                                          |
| Configuratie opslaan                           | <code> end <br> copy running-config startup-config </code>                                             |

## Interfaces configureren

## Default Gateway configureren
