# Scholar

[![Join the chat at https://gitter.im/rehrumesh/scholar](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/rehrumesh/scholar?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Build Status](https://travis-ci.org/rehrumesh/scholar.svg?branch=master)](https://travis-ci.org/rehrumesh/scholar)

Scholar is a web application which redefine the way of scholarships.

##Usage
### Requirements
#### Front-end
* [NodeJS](http://nodejs.org/) (with [NPM](https://www.npmjs.org/))
* [Bower](http://bower.io)
* [Gulp](http://gulpjs.com)

#### Back-end
* [Java 1.6 or above](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Maven](https://maven.apache.org/)
* [MySQL](https://www.mysql.com/)

### Installation
1. In the terminal, navigate to `scholar.backend` directory
2. Build and package: `mvn clean compile package`
3. Start the back-end: `mvn jetty:run`
4. Navigate to `scholar.frontend` directory
5. Install the NodeJS dependencies: `sudo npm install`.
6. Install the Bower dependencies: `bower install`.
7. Run the gulp build task: `gulp build`.
8. Run the gulp default task: `gulp`. This will build any changes made automatically, and also run a live reload server on [http://localhost:8888](http://localhost:8888).



