## Exercise 1
### a) 
Run:
docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:900 sonarqube:latest
	
### d) 
User -> My Account -> Security, fill in name, generate token.
	
### e)
Analysis Results:
![Alt text](Resources/EuromillionsAnalysis.png?raw=true "Euromillions Analysis")

| Issue                      | Problem Description              | How to Solve                          |
|---------------------------:|----------------------------------|---------------------------------------|
| Bug (Critical)             | Save and re-use "Random". | The "generator" variable should not be initialized inside the function, it should be global. |
| Code Smell (Major x2)      | Refactor the code in order to not assign to the loop counter from within the loop body. | Move 'i++' to the inside of the for loop definition. |   |
| Code Smell (Major x7)      | Replace the use of System.out with a logger. | Import java.util.logging and change System.out() to logger.log(). |
| Code Smell (Major)         | Use assertEquals instead. | Replace use of assertTrue with assertEquals. |
| Security Hotspot           | Using pseudorandom number generators (PRNGs) is security-sensitive, the generator may be a potential security threat. | Use a cryptographically strong random number generator (RNG) like "java.security.SecureRandom" in place of this PRNG.


## Exercise 2
### a)
2h7min.
Technical debt is the amount of theoretical time it would take a programmer to fix all the code smells that are present in the project that was analyzed.

### b)
After correcting all major and critical problems, the analysis results were the following:
![Alt text](Resources/EuromillionsAnalysisFixed.png?raw=true "Euromillions Analysis After Fixes")

### d)
Uncovered Lines: 44

Uncovered Conditions: 12

![Alt text](Resources/EuromillionsCodeCoverage.png?raw=true "Euromillions Code Coverage")


## Exercise 3
- For this exercise i decided to analyse the IES project, consisting of an application that would give establishment recomendations based on geolocation and time of day.

- Created the following quality gate to analyze my IES Project:

![Alt text](Resources/QualityGate.png?raw=true "Quality Gate")
- The Conditions which can be seen above were thought of considering that the project had a small-medium scale and would be used by users providing personal information (about whereabouts and, possibly, places they frequently visited), while also taking into consideration that it was an educational project, therefore it shouldn't be riddled with bugs and messy code.

- This resulted in the tests failing, as can be seen in the following picture:

![Alt text](Resources/AnalysisResult.png?raw=true "Analysis Result")

- From the 20 bugs detected, only 2 of them were critical, while 18 were minor bugs. The 2 critical ones consisted of using a .map() instead of .forEach() and a line containing " this.router.navigate[('home')] ", which seemed to not cause any problems.

![Alt text](Resources/Bugs.png?raw=true "Bugs Reported")

- The vulnerability was a major vulnerability, caused by unrestricted access to an android component. In our case, to fix this vulnerability we could change "android:exported='true'" to "android:exported='false'" in the corresponding file.

![Alt text](Resources/Vulnerabilities.png?raw=true "Vulnerabilites Detected")

- The 5 security hotspots encountered all had low review priority, 2 of them were to make sure that permissions to write and read from external storage were in fact needed by our app (these are therefore not important because we ended up not implementing a mobile application, even though some config files were already created to allow it). 2 other security hotspots were related to not verifying the integrity of external resources. The last was related to making sure the use of geolocation was needed, which in our case, was the foundation of the service we were providing, since the location was used to present the user with	recomendations of nearby establishments.

![Alt text](Resources/SecurityHotspots.png?raw=true "Security Hotspots")

- From the 126 code smells reported, 12 of them were critical and 46 were major, leaving 68 minor ones. Most of the critical code smells could be fixed by removing empty methods, the major smells however were more spread out and would take longer to fix, even though most were commented code or useless assignments.

![Alt text](Resources/CodeSmells.png?raw=true "Code Smells")

