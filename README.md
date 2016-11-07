# grails322-plugin-issue
Samples to show loading problem for a Grails 3.2.2 plugin.
This issue has no relationship to Grails 2.

# Directories
* ping: An app with a dependency to the pong plugin
* pong: A plugin with a taglib used by the ping app

# Usage
You are supposed to setup a Grails environment to use the selected Grails version.
Everything is run in development environment.

## Setup
The top directory contains a bash script `setup.sh` for picking versions of
Java, Grails and Gradle.
However, it is adapted to the author's system and most likely does not work for you.
It is intended to be sourced in the shell where you run the tests.

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

During startup you should see output on standard out from the plugin
that shows it is being loaded.

The *show* view should essentially echo your input.

The point of this test run is that the plugin jar is generated
and loaded as expected.

## Test Run 2
Build and install the pong plugin to your local Maven cache.
Notice the slightly different gradle command.
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

This time there won't be any startup output on standard out
because the plugin is not loaded.

You can run the app, but the *show* view does not echo your input.

The reason is that the pong plugin is not loaded.
No diagnostics are shown.
