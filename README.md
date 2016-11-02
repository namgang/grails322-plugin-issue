# grails322-plugin-issue
Samples to show loading problem for a Grails 3.2.2 plugin.
This issue highlights a difference in plugins generated by Grails 3.1
and Grails 3.2.
The exact versions we used were 3.1.11 and 3.2.2.
This issue has no relationship to Grails 2.

# Directories
* ping: An app with a dependency to the pong plugin
* pong: A plugin with a taglib used by the ping app
* handcrafted-jar-for-maven-cache: The contents is a manually modified plugin jar

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

In the show view you will see *Pong says:* to the far left above the *Say Hi* property value.
In this case it doesn't say anything, there is nothing after *Pong says:*.

# Using the Handcrafted Jar

Stop the ping app.
Copy the handcrafted jar into your Maven cache, replacing the original `pong-0.1.jar`.
Run the ping app, repeating the above steps for *ping*, but don't do anything to pong.
If you rebuild pong the handcrafted jar will be overwritten.

This time you should be able to see the following differences.
* Output from *pong* on standard out as the app starts up
* The *show* view should now contain a message after *Pong says:*, repeating your input

If you see this output it means that the plugin is loaded and works.
