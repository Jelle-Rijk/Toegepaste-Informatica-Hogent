# ZFS

Bekijk de datapools met `zpool status`

Alle schijven zijn als bestand terug te vinden in `/dev/disk/by-id/`

|Naam| Disk-id|
|----|--------|
| /dev/sdb | /dev/disk/by-id/ata-VBOX_HARDDISK_VBe8a5cf48-aa40dd08 |
| /dev/sdc | /dev/disk/by-id/ata-VBOX_HARDDISK_VB084dd9d4-09ae493a |


Pool maken: `sudo zpool create <naam> mirror /pad/naar/disk-id-origineel /pad/naar/disk-id-copy`

Alle datapools opvragen: `zpool list`

We beschadigen de bestanden door nullen uit /dev/zero over te schrijven naar een van de schijven.

Disk scrubben: `zpool scrub <datapool>`


|Naam|Oude disk-id|Nieuwe disk-id|
|----|------------|--------------|
| /dev/sdb | /dev/disk/by-id/ata-VBOX_HARDDISK_VBe8a5cf48-aa40dd08 | /dev/disk/by-id/ata-VBOX_HARDDISK_VB77aa4323-75ae4a62 |