# OSGi Playground

This is a project to play around with [OSGi][osgi] based on [Apache Karaf][karaf].

## Setup & Run Karaf

_NOTE_: This repo  only contains Karaf for  Linux/Unix. If you want  to run it
on  Windows  you  must  download  the Windows  distribution  from  the  [download
site](http://karaf.apache.org/index/community/download.html#Karaf3.0.5).

1. run the script `setup-karaf.sh`
2. cd into `karaf`
3. run [Karaf][karaf] with `./bin/karaf`
5. build the features with `mvn clean install`
6. install the features:
    - `feature:repo-add mvn:de.weltraumschaf.nas/nas-features/1.0.0-SNAPSHOT/xml`
    - `feature:install nas-features`

*Hint*: If  you changed  the code you  only need to  invoke `mvn  clean deploy`.
This will build  all the stuff and  copies the bundle JARs into  the auto deploy
directory of Karaf (`karaf/deploy`).

## Tutorials

- [Karaf Tutorials - Liquid Reality - Christian Schneider's Blog](http://liquid-reality.de/display/liquid/Karaf+Tutorials)

## Links

- [What is Apache Karaf?](http://stackoverflow.com/questions/17350281/what-exactly-is-apache-karaf)
- [OSGi bundle exception](http://stackoverflow.com/questions/11161871/org-osgi-framework-bundleexception-could-not-find-bundle-org-eclipse-equinox-c)

[equinox]:  http://www.eclipse.org/equinox/documents/quickstart.php
[osgi]:     https://de.wikipedia.org/wiki/OSGi
[karaf]:    http://karaf.apache.org/
[jersey]:   https://jersey.java.net/