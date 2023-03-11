# Code quality and Coverage

## Java Source Code Analysis using SonarQube in Eclipse 
- src : https://www.youtube.com/watch?v=hyBznKcoKEg  , code : https://github.com/Java-Techie-jt/sonar-example
- code smell , bugs and vulnerabilities
- 
```java
Plugins:
org.sonarsource.scanner.maven sonar-maven-plugin 3.4.0.905 org.jacoco jacoco-maven-plugin 0.8.1
jacoco cmd:
clean org.jacoco:jacoco-maven-plugin:prepare-agent install

sonar cmd:
mvn sonar:sonar
```

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


