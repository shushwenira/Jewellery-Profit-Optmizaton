Software stack used while developing and running the project:	
 - Language: Java 9
 - Compiler: jdk-9.0.4
 - IDE: Eclipse JEE Oxygen
 - O/S: Windows 10

Instructions to run the project from command line:
 - Naviagate to sxk173732/ and open command prompt at this location
	- Compile the source file 
		- "javac Sxk173732Project6363.java"
  - Return to previous folder 
	- cd..
  - Run using one of the following commands based on the variations
	- Without enumeration
		- Read input from console
			- "java sxk173732.Sxk173732Project6363" or "java sxk173732.Sxk173732Project6363 -"
				- Enter the amount of gold and number of items required followed by specifications for each item per line
					- eg: 20 2
						- 1 2 10 8 10 2 2
						- 2 2 10 8 10 2 4
		- Read input from file
			- "java sxk173732.Sxk173732Project6363 <filename>"
				- <filename> is the absolute path
	- With Enumeration
		- Add a second parameter whose value is greater than 0 to the above commands
