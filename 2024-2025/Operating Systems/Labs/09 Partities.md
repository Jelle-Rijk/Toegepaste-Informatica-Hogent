# Partities

|Taak|Commando|
|----|--------|
| Overzicht van block devices weergeven | `lsblk`|
|Type filesystems weergeven| `lsblk -o name,fstype`|
|Filesystem mounten|`sudo mount /dev/filesystem pad/naar/target/directory`|

FAT32 filesystems hebben geen ondersteuning voor Linux gebruikersrechten, dus de partities worden door root gemount i.p.v. door de gebruiker.


-> Na koppeling van de harde schijf aan Windows, is de eerste partitie niet zichtbaar omdat ext4 niet wordt ondersteund door Windows.