# BootDocker

## SpringBoot - Docker
- Dockerfile 생성
- gradle 빌드
- Docker imgae build
```
// image build
docker build -t bootdocker:v1 .
// container run
docker run -d --name bootdocker -p 8888:8080 bootdocker:v1
// run check
docker ps
// call
curl http://localhost:8888/jaemin
```
