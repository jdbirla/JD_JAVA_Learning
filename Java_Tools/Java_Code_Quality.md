# Code quality and Coverage


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
3. we can add custom quality profiles and qualtiy gates
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
- dockercompose.yml
```yaml
version: "3.8"

services:
  sonarqube:
    image: techforum/sonarqube-with-custom-plugins-aem:latest
    container_name: sonarqube
    depends_on:
      - db
    ports:
      - "9000:9000"
    networks:
      - sonarnet
    environment:
      - sonar.jdbc.username=sonar
      - sonar.jdbc.password=sonar
      - sonar.jdbc.url=jdbc:postgresql://db:5432/sonar
      - SONARQUBE_ADMIN_PASSWORD=Welcome1
    volumes:
      - sonarqube_data:/opt/sonarqube/data
      - sonarqube_logs:/opt/sonarqube/logs
  db:
    image: postgres:latest
    container_name: postgres
    networks:
      - sonarnet
    environment:
      - POSTGRES_USER=sonar
      - POSTGRES_PASSWORD=sonar
      - POSTGRES_DB=sonar
    volumes:
      - postgresql_data:/var/lib/postgresql/data

networks:
  sonarnet:
    driver: bridge

volumes:
  sonarqube_data:
  sonarqube_logs:
  postgresql_data:
  ```
 ---
 ## Sonarlint connected mode with eclipse and sonarQube in docker
 - add plugin in eclipse sonarlint
 - sonarlinit standlone mode
 ![image](https://user-images.githubusercontent.com/69948118/224470673-b4cccc69-6f9f-4bb4-ab80-176aa5bbb751.png)
- sonar qube connected mode
- create project
![image](https://user-images.githubusercontent.com/69948118/224470765-02b78185-c55a-490b-9557-42cc4b478776.png)
![image](https://user-images.githubusercontent.com/69948118/224470804-c3c0b09a-7759-4198-b133-85cde6831d92.png)
![image](https://user-images.githubusercontent.com/69948118/224470811-ee7fe593-894c-473e-ab1f-14bbfce9ffd3.png)
![image](https://user-images.githubusercontent.com/69948118/224470827-4d3e2bae-8c82-4a05-910d-b4687a8bff09.png)
![image](https://user-images.githubusercontent.com/69948118/224470845-8cea2624-1f2c-4d8c-9772-380cf1404290.png)
![image](https://user-images.githubusercontent.com/69948118/224470943-e6cab1df-2d4b-45bb-8527-5dd93cc37418.png)

---
## Code Coverage Report with jaCOCO, maven and SonarQube
- https://github.com/techforum-repo/youttubedata/tree/master/test-coverage-report-jacoco
- first check if jacoco plugins installed in sonarQube in below URL
![image](https://user-images.githubusercontent.com/69948118/224471125-f103ce4f-d28b-4c2f-aa57-826c649e70fd.png)
![image](https://user-images.githubusercontent.com/69948118/224471735-c0d5fa15-d947-4d67-b6a5-cc06693bc2dc.png)
- We can generate jacoco coverage using eclipse also enabling plugin eclemma

---

