#!/bin/bash

echo "Welcome to the Troll Bridge demo!"
echo
echo "Enter # of goats (Press enter for 'cute' edition):"
read input

if( [ -d "goats" ] && [ -d "trolls" ] && [ -d "queues" ] && [ -f "Bridge.class" ] )
then
		echo
		echo "Files already compiled, would you like to recompile [ (y)es / (n)o ]?"
		read answer
		echo

		if [ $answer == "y" ] || [ $answer == "yes" ]
		then
			rm *.class goats/*.class trolls/*.class queues/*.class
			rmdir goats trolls queues
			javac -d goats src/goats/*.java -d trolls src/trolls/*.java -d queues src/queues/*.java -d . src/Bridge.java
		fi
else
		javac -d goats src/goats/*.java -d trolls src/trolls/*.java -d queues src/queues/*.java -d . src/Bridge.java
fi

echo "Beginning demo..."
echo
java Bridge $input
echo
echo "...demo complete!"