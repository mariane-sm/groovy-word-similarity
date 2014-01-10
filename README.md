groovy-word-similarity
======================

Practicing with Groovy / Gradle / Spock

A word is similar to another word only if:
	- at most 1 letter is different (ie: tomato and tomata = similar) or
	- there is at most 1 extra letter (ie: tomato and tomatox = similar) or
	- there is at most 1 letter missing (ie: tomato and tomat = similar)



Remember:

To start a groovy project with Gradle: gradle init --type groovy-library 
(it creates a src folder, gradle config files such as build.gradle with spock dependency)

To run test: gradle test
To run main file: groovy path/filename.groovy
