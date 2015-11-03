# OSGi Playground

This is a project to play around with [OSGi][osgi] based on [Apache Karaf][karaf].

## Setup & Run Karaf

__NOTE__: This repo  only contains Karaf for  Linux/Unix. If you want  to run it
on  Wndows  you  must  download  the Windows  distribution  from  the  [download
site](http://karaf.apache.org/index/community/download.html#Karaf3.0.5).

1. run the script `setup-karaf.sh`
2. cd into `karaf`
3. run [Karaf][karaf] with `./bin/karaf`
4. install [Jersey][jersey] bundles in [Karaf][karaf]
    - bundle:install mvn:com.sun.jersey/jersey-core/1.18.1
    - bundle:install mvn:com.sun.jersey/jersey-server/1.18.1
    - bundle:install mvn:com.sun.jersey/jersey-servlet/1.18.1

## Tutorials

- [Karaf Tutorials - Liquid Reality - Christian Schneider's Blog](http://liquid-reality.de/display/liquid/Karaf+Tutorials)

## Links

- [What is Apache Karaf?](http://stackoverflow.com/questions/17350281/what-exactly-is-apache-karaf)
- [OSGi bundle exception](http://stackoverflow.com/questions/11161871/org-osgi-framework-bundleexception-could-not-find-bundle-org-eclipse-equinox-c)

[equinox]:  http://www.eclipse.org/equinox/documents/quickstart.php
[osgi]:     https://de.wikipedia.org/wiki/OSGi
[karaf]:    http://karaf.apache.org/
[jersey]:   https://jersey.java.net/