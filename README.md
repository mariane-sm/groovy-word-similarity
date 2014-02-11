groovy-word-similarity
======================

###Practicing with Groovy / Gradle / Spock

#####A word is similar to another word only if: 

	- at most 1 letter is different  
	ie: tomato and tomata = similar) 

	or  

	- there is at most 1 extra letter   
	(ie: tomato and tomatox = similar) 

	or  

	- there is at most 1 letter missing  
	(ie: tomato and tomat = similar)  


#####Tips:

To start a groovy project with Gradle:  
gradle init --type groovy-library (it creates a src folder, gradle config files such as build.gradle with spock dependency)

To build:  
gradle build

To run tests:  
gradle test

To run main class:  
gradle run (put this line at build.gradle --> mainClassName = "wordSimilarityChecker.Main")

SLF4J: This project uses SLF4J implemented with Logback. It uses jlc-over-slf4j in order to be able to adapt
Jakarta-Commons-Logging to SLF4. If any project uses other interface to log, check http://mvnrepository.com/artifact/org.slf4j to find the appropriate adapter.
