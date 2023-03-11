# Code quality and Coverage

## Java Source Code Analysis using SonarQube and Jacoco in Eclipse 
- src : https://www.youtube.com/watch?v=hyBznKcoKEg  , code : https://github.com/Java-Techie-jt/sonar-example
- code smell , bugs and vulnerabilities
```xml
	<build>
		<plugins>
			<plugin>
				<groupId>org.sonarsource.scanner.maven</groupId>
				<artifactId>sonar-maven-plugin</artifactId>
				<version>3.4.0.905</version>
			</plugin>
			<!-- https://mvnrepository.com/artifact/org.jacoco/jacoco-maven-plugin -->
			<plugin>
				<groupId>org.jacoco</groupId>
				<artifactId>jacoco-maven-plugin</artifactId>
				<version>0.8.1</version>
			</plugin>

		</plugins>
	</build>
 
 ```
```java
Plugins:
org.sonarsource.scanner.maven sonar-maven-plugin 3.4.0.905 org.jacoco jacoco-maven-plugin 0.8.1
jacoco cmd:
clean org.jacoco:jacoco-maven-plugin:prepare-agent install

sonar cmd:
mvn sonar:sonar
```
- Start sonarqube
   - from download folder for bin ans start startSonar bat file
   - ![image](https://user-images.githubusercontent.com/69948118/224460255-ee8c1f58-dcae-4a7b-a4ac-d5b0267f95e8.png)
  ![image](https://user-images.githubusercontent.com/69948118/224460269-74c02996-3e0a-4308-a945-0d3ccbdc52db.png)
- run jacoco for code coverage
- Run as mvn build `clean org.jacoco:jacoco-maven-plugin:prepare-agent install`
![image](https://user-images.githubusercontent.com/69948118/224460330-69c45650-7496-4633-a3b1-d5bad1c6c2f0.png)
- Run as sonarqube `mvn sonar:sonar`
![image](https://user-images.githubusercontent.com/69948118/224460406-348b2f70-65df-499b-826c-dbb355004787.png)
![image](https://user-images.githubusercontent.com/69948118/224460439-872214e1-4a93-48c7-aa03-5a03635c61db.png)
![image](https://user-images.githubusercontent.com/69948118/224460448-c2c1006f-4c0e-4e58-a80e-21bb6e8bda19.png)
![image](https://user-images.githubusercontent.com/69948118/224460490-8ce587bc-d38f-4c50-89f3-1be664832a2c.png)
- fix the issues and write test cases
- run again jacoco and sona mvn commands
![image](https://user-images.githubusercontent.com/69948118/224460706-a0655ad5-91bb-409d-b92f-f990f86e81c5.png)














---
## Sonarlint Connected Mode with Eclipse and SonarQube(Docker) 
 - src : https://www.youtube.com/watch?v=PPWeiHz7X00 , https://www.youtube.com/watch?v=cvMCfmZ2XZ0
 - 
![image](https://user-images.githubusercontent.com/69948118/178614858-7f2a1076-dfcc-4388-8b0f-50b6c220636c.png)






### Code Quality 

sonar-example

What is sonar how to get start with it | Example
```
Plugins:
org.sonarsource.scanner.maven sonar-maven-plugin 3.4.0.905 org.jacoco jacoco-maven-plugin 0.8.1

jacoco cmd:

clean org.jacoco:jacoco-maven-plugin:prepare-agent install
sonar cmd:

mvn sonar:sonar

```

1.  Install the SonarQube plugin for Eclipse.

2.  Configure your SonarQube server.

3.  Link your workspace project to the copy on SonarQube.

4.  Add the SonarQube views to your current perspective.

---


