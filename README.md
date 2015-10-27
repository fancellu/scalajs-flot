![scalajs-flot Logo](http://felstar.com/projects/scalajs-flot/img/scalajs-flot-cliff.png)
# scalajs-flot

## Scala.js bindings for Flot and example applications 

Example apps showing the use of [Scala.js](http://www.scala-js.org/) with [Flot](http://www.flotcharts.org//) 
The bindings for Flot are in `com.felstar.scalajs.flot`

## Get started

To get started, run `sbt ~fastOptJS` in this example project. 

Obviously you need to have [SBT](http://www.scala-sbt.org/) installed. 

This should
download dependencies and prepare the relevant javascript files. It then kicks off a web server to serve the html and JS files.

If you open
[localhost:12345/target/scala-2.11/classes/flot1-dev.html](http://localhost:12345/target/scala-2.11/classes/flot1-dev.html) in your browser, it will show you a sample app, drawing 2 graphs. Do open the Console to see debug messages. There are also 2 other code samples.

## Live Demo

[Basic Flot demo](http://dinofancellu.com/demo/scalajsFlot/flot1-dev.html)

[Time demo](http://dinofancellu.com/demo/scalajsFlot/time1-dev.html)

[RealTime demo](http://dinofancellu.com/demo/scalajsFlot/realtime-dev.html)


## Development

If you change your source HTML (inside `/src/main/resources`) or Scala (inside `/src/main/scala/example`), sbt will recompile as needed. 
You then just have to refresh the page to see the new version. Hopefully having an example application will make it clearer on how to use Flot from Scala, i.e. monkey see, monkey do.

## The optimized version

Run `sbt fullOptJS` for an optimized version
of the final application, useful for final publication. You may well need to copy over `XXX-dev.html` to get your latest changes. Be sure to refer to the correct JS as well, as it will have a different name than the fast compiled version. e.g.

	<script type="text/javascript" src="../scala-js-flot-js-example-opt.js"></script>

## Eclipse integration

If you want to edit in Eclipse (can't compile yet, but still very useful having full IDE with code completion), just run `sbt eclipse` the open the generated .project file inside eclipse. Keep sbt running in order to do the JS Compile. [https://github.com/typesafehub/sbteclipse/wiki](https://github.com/typesafehub/sbteclipse/wiki)

## Status

This is just a quick proof of concept and some bindings for those wanting to use Flot from Scala.js. Feel free to get in contact with any issues etc.


