normalizer
==========

Normaliza tablas de una base de datos.
##INTRODUCCI�N
Normalizer es la aplicaci�n que se dedica a analizar tablas de una base de datos en busca de aplicarle una normalizaci�n. 
La aplicaci�n est� construido con java. Actualmente se encuentra en etapa temprana desarrollo y se conecta exclusivamente con PostgresSQL (compatible con PostgreSQL 9.2). 
El IDE de preferencia es [NetBeans] versi�n 7.3 pero cualquier IDE compatible con Java 7 basta.
##DRIVER JDBC
La aplicaci�n Java se conecta a una sesi�n de usuario PostgresSQL versi�n 9.2 con el driver jdbc llamado `postgresql-9.2-1002.jdbc4.jar` disponible en la carpeta `lib/` del ejecutable principal o descargable de:
http://jdbc.postgresql.org/download/postgresql-9.2-1002.jdbc4.jar
Pr�cticamente consiste en un fichero `.jar`, la cual debe ser ubicado en un directorio indicado por el classpath de java. �sta puede ser la carpeta `lib/` relativo a la ubicaci�n del ejecutable principal o tambi�n de la carpeta de desarrollo `normalizer/lib/`. 
##LICENCIA
```
                   GNU LESSER GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.
```
Una copia de la licencia lgpl se encuentra adjunto en la carpeta de desarrollo "normalizer/lgpl-3.0.txt" o disponible en: http://www.gnu.org/licenses/lgpl-3.0.txt
[NetBeans]: https://netbeans.org/downloads/