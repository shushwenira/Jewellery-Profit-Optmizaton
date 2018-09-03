Software stack used while developing and running the project	
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
					- Enter the amount of gold and number of items required followed by specifications
					  for each item per line
						    eg: 20 2
							1 2 10 8 10 2 2
							2 2 10 8 10 2 4
			- Read input from file
				- "java sxk173732.Sxk173732Project6363 <filename>"
					- <filename> is the absolute path
		- With Enumeration
			Add a second parameter whose value is greater than 0 to the above commands

Instructions to run the project from eclipse IDE:
	- Create a new java project with package sxk173732. Copy the source file in the package. 
	  	- Right click source file --> Run As -> Run Configurations.
	- Click on Arguments tab. Under Program arguments, enter the following based on variations.
		- Without Enumeration
			- Read from console
				- Leave it blank or enter '-'
					- Run the source file and enter the amount of gold and number of items required followed
					  by specifications for each item per line on console
						eg: 20 2
						    1 2 10 8 10 2 2
						    2 2 10 8 10 2 4
			- Read from file
				- enter absolute path of filename where input is typed
		- With enumeration
			- add a second parameter whose value is greater than 0.
