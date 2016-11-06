# grails322-plugin-issue
Samples to show loading problem for a Grails 3.2.2 plugin.
This issue has no relationship to Grails 2.

# Directories
* ping: An app with a dependency to the pong plugin
* pong: A plugin with a taglib used by the ping app

# Usage
You are supposed to setup a Grails environment to use the selected Grails version.
Everything is run in development environment.

The top directory contains a bash script `setup.sh` for picking versions of
Java, Grails and Gradle.
However, it is adapted to the author's system and most likely does not work for you.
It is intended to be sourced in the shell where you run the tests.

Either modify it to suit your needs, or follow your own conventions.

Build and install the pong plugin to your local Maven cache.
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

* Under *Available Controllers*, click *ping.PingController*
* Click *New Ping*
* Fill in *Say Hi* with an arbitrary string and click *Create*
* Watch the *show* view
