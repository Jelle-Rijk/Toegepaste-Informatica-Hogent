# Port bindings en volumes

Je moet de poorten van de container verbinden met die van de host.

`docker run -p hostPort:containerPort nginx`
<br> Deze website is nu bereikbaar via localhost:8123

-> Alternatief voor `docker ps` = `docker container ls`

Commando uitvoeren in een container: <code>docker exec <i>containerID [commando]</i></code>
<br> -> met de optie -it kan je inloggen op een container alsof het een gewone Linux-machine is

Veranderingen die je uitvoert binnen de container, zijn lokaal. Nieuwe containers starten altijd vanuit de image (zoals je twee instanties van dezelfde app open kan hebben - vergelijking met Notepad)

## Datapersistentie

-> Via bind mount: directory op file system van de host koppelen met een directory in de container

```bash
docker run -p 8001:80 -v hostDirectory:containerDirectory nginx
```
-> De optie -v koppelt een directory aan de directory in de container.