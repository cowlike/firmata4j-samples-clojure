# firmata4j-samples-clojure

Some simple demos of firmata4j client code written in Clojure. Originally some of these were
written in Groovy for the CJUG Maker Track meeting @ SPR on 6/25.

Original Blink code came from cjug-firmata4j-demo-groovy project. Added Eclipse configuration
and the HourGlass sample code from the Firmata book, translated into Clojure.

## Usage

Example of running blink-one on COM8

    $ java -jar firmata4j-samples-clojure-0.1.0-standalone.jar [args]
    $ java -jar firmata4j-samples-clojure-0.1.0-standalone.jar blink-one COM8

This works by putting Firmata on the Arduino, after which you can control the pins over your 
USB port. In the Arduino IDE, you can find Firmata under File/Examples/Firmata/StandardFirmata.

## Options

FIXME: needs proper arg processing with help...

## Examples

...

## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
