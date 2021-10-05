#clono i progetti
```bash
cd /d/myworkspace/MOTI/moti-web
git clone ssh://gogs/moti/motibe.git
git clone ssh://gogs/moti/motiweb.git
```

#DB TEST
```
jdbc:postgresql://10.136.6.151:5432/moti
USER: moti
PWD:  moti
```
TEST
`http://10.136.6.151/moti/home`

#Terminare i processi sul db
```sql
SELECT pg_terminate_backend(pg_stat_activity.pid)
FROM pg_stat_activity
WHERE pg_stat_activity.datname = 'moti';
```

## Comandi Maven
Compilazione: `mvn clean package`

Sonar: `mvn clean package sonar:sonar -Psonar`

OWASP dependencies check: `mvn clean package org.owasp:dependency-check-maven:check -Powasp`

##Dump DB
Dump in plain text (with plain inserts):

```bash
DEV-NIVOLA: pg_dump --format=p --inserts --file=./moti.$(date +%Y%m%d).dmp --verbose --host=10.138.154.6 --port=10548 --username=moti --dbname=MOTI --schema=moti
TST-NIVOLA: pg_dump --format=p --inserts --file=./moti.$(date +%Y%m%d).dmp --verbose --host=10.138.154.6 --port=10603 --username=moti --dbname=MOTI --schema=moti
```

Import via

```bash
psql --single-transaction --echo-errors --variable=ON_ERROR_STOP=ON --hostname=<HOST> --username=<USER> --dbname=<DBNAME> --file=<FILE>
```
---
Dump custom:

```bash
pg_dump --format=c --compress=9 --file=./moti.$(date +%Y%m%d).dmp --verbose --hostname=<HOST> --username=<USER> --dbname=<DBNAME>
```
Import via

```bash
pg_restore
```
