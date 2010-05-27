# IMPORTANT

This is a very old and outdated library, if you attempt to use it against the current version of Gnip it will not work.
I'm leaving this code up on github only as a reference.

## Overview

Welcome to Gnip's Java convenience library!

This library produces a single JAR file called gnip-client-<version>.jar that can be used
to conveniently access Gnip services. The implementation depends on Java 1.6 features; Java
1.5 or earlier environments are not supported.

## Building

Building this library requires maven2. Maven can be downloaded from http://maven.apache.org/.

To build the library, run: mvn compile

To clean the library, run: mvn clean

To package the library into its JAR, run: mvn package

## Testing

To test the library, create the file:

  src/test/resources/test.properties

which holds the username, password, and host properties used to
connect to Gnip.  This file should be of the format:

gnip.username=darthvader@deathstar.mil
gnip.password=goempire
gnip.host=https://api-v21.gnip.com
gnip.publisher=mypublisher
# the number of seconds to wait between each test's setup / teardown
gnip.idlesecs=2 

Note, the JUnit tests publish activities to a Publisher.  You can only own publish
activities to a Publisher when you own it, so create a Publisher and provide its
name above in the "gnip.publisher" property.

To test the library, run: mvn test
