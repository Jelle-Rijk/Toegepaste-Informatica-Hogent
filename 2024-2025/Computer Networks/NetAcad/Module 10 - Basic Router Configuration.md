# Basic Router Configuration

- [Initial Router Settings configureren](#initial-router-settings-configureren)
- [Interfaces configureren](#interfaces-configureren)
- [Default Gateway configureren](#default-gateway-configureren)

Routers configureren loopt gelijkaardig aan het configureren van Switches (zie hiervoor ook [module 2](Module%2002%20-%20IOS.md))

## Initial Router Settings configureren

| Taak                                           | EXEC mode     | Commando                                                                                         |
| ---------------------------------------------- | ------------- | ------------------------------------------------------------------------------------------------ |
| Device naam configureren                       | global config | hostname _hostname_                                                                              |
| Wachtwoord instellen voor privileged EXEC mode | global config | enable secret _password_                                                                         |
| Lijn configureren                              | global config | line _type number_                                                                               |
| User EXEC mode password instellen              | line config   | password _password_                                                                              |
| Gebruik van passwords verplichten              | line config   | login                                                                                            |
| Telnet / SSH access beveiligen                 | line config   | line vty _nummer nummer_ <br> password _password_ <br> login<br>transport input { ssh \| telnet} |
| Terug naar global config van line config       | line config   | exit                                                                                             |
| Passwords encrypten                            | global config | service password-encryption                                                                      |
| Banner instellen                               | global config | banner motd _delimiter message delimiter_                                                        |
| Config mode verlaten                           | global config | end                                                                                              |
| Running-config naar startup-config kopiëren    | privileged    | copy running-config startup-config                                                               |

| Taak                                           | Commando                                                                                               |
| ---------------------------------------------- | ------------------------------------------------------------------------------------------------------ |
| Device naam configureren                       | <code> hostname <i>hostname</i> </code>                                                                |
| Wachtwoord voor privileged EXEC mode instellen | <code> enable secret <i>password</i></code>                                                            |
| User EXEC mode beveiligen                      | <code> line console 0 <br> password <i>password</i> <br> login </code>                                 |
| Telnet / SSH beveiligen                        | <code> line vty 0 4 <br> password <i>password</i><br>login<br>transport input { ssh \| telnet} </code> |
| Wachtwoorden beveiligen                        | <code> exit <br> service-password-encryption</code>                                                    |
| Banner instellen                               | <code> banner motd <i>delimiter message delimiter</i> </code>                                          |
| Configuratie opslaan                           | <code> end <br> copy running-config startup-config </code>                                             |
| IPv6 routing enablen                           | <code> ipv6 unicast-routing </code>                                                                    |

## Interfaces configureren

| Taak                                              | EXEC mode        | Commando                                  |
| ------------------------------------------------- | ---------------- | ----------------------------------------- |
| Interface selecteren                              | global config    | interface _type-and-number_               |
| Description toevoegen                             | interface config | description _description-text_            |
| IPv4 assignen                                     | interface config | ip address _ipv4-address subnet-mask_     |
| IPv6 assignen                                     | interface config | ipv6 address _ipv6-address/prefix-length_ |
| Interface opstarten                               | interface config | no shutdown                               |
| Overzicht van interfaces met IPv4's               | privileged       | show ip interface brief                   |
| Overzicht van interfaces met IPv6's               | privileged       | show ipv6 interface brief                 |
| Toon inhoud van de IP routing tables in ram       | privileged       | show ip route / show ipv6 route           |
| Statistieken van alle interfaces (IPv4-addressen) | privileged       | show interfaces                           |
| IPv4 statistieken interface                       | privileged       | show ip _interface_                       |
| IPv6 statistieken voor interface                  | privileged       | show ipv6 _interface_                     |
| Default gateway instellen                         | global config    | ip default-gateway _ip-address_           |

Als je switches remotely wil instellen, moet er een Switch Virtual Interface (SVI) ingesteld zijn, en moet de switch een default gateway hebben.
