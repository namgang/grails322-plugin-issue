# grails322-plugin-issue
Samples to show how subtly plugin generation toggles between
plain jar output and a Boot repackaged jar.
Originally I thought this was a problem in Grails 3.2.2, but that's not the case.
Grails 3.1.11 behaves the same way.

This issue has no relationship to Grails 2.

# Directories
* ping: An app with a dependency to the pong plugin
* pong: A plugin with a taglib used by the ping app

# Usage
The following text describes how to build and run the app with its plugin.
Two test cases are described.

## Setup
You are supposed to setup a Grails environment to use the selected Grails version.
Everything is run in development environment.

The top directory contains a bash script `setup.sh` for picking versions of
Java, Grails and Gradle.
However, it is adapted to the author's system and most likely does not work for you.
It is intended to be sourced into the shell where you run the tests.

Either modify it to suit your needs, or follow your own conventions.

## Test Run 1
Build and install the pong plugin to your local Maven cache.
```bash
cd pong
gradle clean install
```

Build and run the ping app.
```bash
cd ping
grails
grails> clean
grails> run-app
```

* Browse to the running app
* Under *Available Controllers*, click *ping.PingController*
* Click *New Ping*
* Fill in *Say Hi* with an arbitrary string and click *Create*
* Watch the *show* view

During startup you should see output on standard out from the pong plugin
that shows it is being loaded.

The *show* view should essentially echo your input.

The point of this test run is that the plugin jar is generated, loaded
and works as expected.

## Test Run 2
Build and install the pong plugin to your local Maven cache.
**Notice the slightly different gradle command.**
```bash
cd pong
gradle clean build install
```

Build and run the ping app.
```bash
cd ping
grails
grails> clean
grails> run-app
```

* Browse to the running app
* Under *Available Controllers*, click *ping.PingController*
* Click *New Ping*
* Fill in *Say Hi* with an arbitrary string and click *Create*
* Watch the *show* view

The behaviour is different:
* No output on standard out during startup
* The *show* view does not echo your input

The reason is that the pong plugin is never loaded.
It is discarded because it was generated as a Boot repackaged jar.
There is a WARN log message during startup, but you won't see it without
changing log levels in the logging configuration.
