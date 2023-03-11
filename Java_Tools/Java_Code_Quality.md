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
## SonarQube in Docker container and boostrap the quality configuration
 - src : https://www.youtube.com/watch?v=PPWeiHz7X00 , https://www.youtube.com/watch?v=cvMCfmZ2XZ0
 - https://www.youtube.com/watch?v=PPWeiHz7X00&list=PLS9bA57u8gj_p6G1or9xcq_W2BLYNxTvB&index=1&ab_channel=TechForum
 - github : https://github.com/techforum-repo/docker-projects
 - github : https://gist.github.com/techforum-repo/ce8387c174d92e75add7a9660ecbbc1f
1. get sonar image fomr ocker  `docker pull sonaqube`
docker pull <<Image Name>> e.g docker pull sonarqube
2. run docker container
```
	docker run -d --name sonarqube -p 9000:9000 sonarqube:latest (-d In background, --name associate name for the container)
```
3. we add custom configuration and gates
4. docker commanda
	
### Pull the docker image

```
docker pull <<Image Name>> e.g docker pull sonarqube
```

### Run Docker Image

```
docker run -d --name sonarqube -p 9000:9000 sonarqube:latest (-d In background, --name associate name for the container)
docker run --name sonarqube -p 9000:9000 sonarqube:latest
docker run --rm --name sonarqube -p 9000:9000 -e SONARQUBE_ADMIN_PASSWORD="Welcome1" techforum/sonarqube-with-custom-plugins-aem:latest(--rm remove existing container,-e SONARQUBE_ADMIN_PASSWORD="Welcome1" environment variable) 
docker run --rm --name sonarqube -p 9000:9000 -v /mnt/c/Albin/blogData/docker-container-files/data:/opt/sonarqube/data -v /mnt/c/Albin/blogData/docker-container-files/logs:/opt/sonarqube/logs -e SONARQUBE_ADMIN_PASSWORD="Welcome1" techforum/sonarqube-with-custom-plugins-aem:latest (-v volume mapping, map docker volume to host folder)
```

### Push Image to Docker Hub

```
docker push techforum/sonarqube-with-custom-plugins-aem:latest
```

### List out the active containers

```
docker ps -a 
docker ps -a -f name=sonarqube(container with specific name)
```

### Restart container

```
docker container restart sonarqube
```

### Stop Container

```
docker container stop sonarqube
```

### Restart Container

```
docker container restart sonarqube
```

### Start Container

```
docker container start sonarqube
```

### Verify Container Logs

```
docker logs sonarqube
```

### Run multi container application (execute the docker compose comands from the folder where docker-compose.yml file is stored)

```
docker-compose up
docker-compose up -d  (-d run the containers in background)
```

### Stop the Containers

```
docker-compose stop
```

### Start the Containers

```
docker-compose start
```

### View Docker Composer Logs

```
docker-compose logs -f (-f displays the current logs)
```

### List the volumes

```
docker volume ls
```

### Remove Volume

```
docker volume rm -f <Volume Name>
```

### Inspect Volumes

```
docker inspect <Volume Name>
docker inspect --format="{{.Mounts}}" <Container Name>
docker inspect <Volume Name> | grep Mountpoint | awk '{ print $2 }'
```

### Execute Commands inside running container

```
docker exec -it <Container Id> /bin/bash  (execute the the commands in the bash shell)
```
	
 ---
## SonarQube in a docker contianer with external Database
	
 
 

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


