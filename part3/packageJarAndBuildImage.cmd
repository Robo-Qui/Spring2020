ECHO maven package
call mvnw.cmd clean package -Dmaven.test.skip

ECHO Docker build image
docker build -t taa_project .

ECHO NOW you can start image with "docker run -p 8081:8081 taa_project"