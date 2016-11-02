A Grails app with a single domain, ping.Ping, with a single property.
The show.gsp view uses a tag "pong:ack".
The tag is implemented by the pong plugin (see sibling directory).

Using the H2 database by default you have to create a new Ping
every time you start up the app.
The "show" view has some ugly output above the main property list.
If you only see "== ==" the app has not found the taglib for the
"pong:ack" tag
Otherwise there should be a message between those markers.
