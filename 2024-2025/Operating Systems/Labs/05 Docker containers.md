# Docker Containers

## Docker installeren

1. [Oude installaties verwijderen](https://docs.docker.com/engine/install/ubuntu/#uninstall-old-versions)
2. [Docker repository toevoegen aan package manager](https://docs.docker.com/engine/install/ubuntu/#install-using-the-repository)

Stap 2 is belangrijk omdat de meeste package managers met verouderde versies van Docker werken. De repository van Docker zelf garandeert dat we met de laatste versie kunnen werken zonder dat we de binaries handmatig moeten downloaden / uitvoeren.
<br> -> na uitvoeren van deze stap, checkt apt de Docker repository

*Curl* -> applicatie om zaken te downloaden in de terminal via een URL
<br/> *Ca-Certificates* -> applicatie om te werken met certificaten

Als je docker wil uitvoeren zonder sudo, moet je de user toevoegen aan de Docker group.

```bash
sudo usermod -a -G docker $USER
# $USER is de huidige user.
```

## Containers runnen

Controleer welke containers runnen: `sudo docker ps`
<br/> *optie `-a` toevoegen als je ook afgesloten containers wil zien*
```bash
CONTAINER ID   IMAGE         COMMAND    CREATED         STATUS                     PORTS     NAMES
4096e5a7b7cc   hello-world   "/hello"   4 minutes ago   Exited (0) 4 minutes ago             crazy_perlman
b350f7f24980   nginx     "/docker-entrypoint.…"   14 seconds ago   Up 13 seconds   0.0.0.0:8123->80/tcp, [::]:8123->80/tcp   beautiful_kalam

```

Ports -> Welke poort op de host doorgestuurd wordt naar welke poort op de container. (In dit voorbeeld wordt poort 8123 van de host verbonden met poort 80 op de container)
<br> *instellen met* `docker run -p 8123:80 nginx`


**Handige commando's**
|Taak|Commando|
|----|----|
| Container opstarten | <code>docker run <i>containerNaam</i></code> |
|Alle gedownloade images opvragen| `sudo docker images`|
|Alle containers, images en volumes die niet in gebruik zijn verwijderen| `docker system prune -a --volumes`|
|Container starten|`docker start containerID`|
|Container updaten|`docker container update <CONTAINER ID>`|
|Container stoppen|`docker stop <CONTAINER ID>`|
|Container verwijderen|`docker rm <CONTAINER ID>`|
