A Grails plugin that implements the "pong:ack" tag used by the "ping" app.
The plugin descriptor, src/main/groovy/pong/PongGrailsPlugin.groovy,
has a "println" in its "doWithSpring" and "doWithApplicationContext".
You should see the output when the ping app starts as a first sign that
the plugin is being loaded.
