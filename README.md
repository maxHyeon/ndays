# simpe-docker-proj

> docker 공부 정리

## TODO

- Docker 설치부터 기초 실행 명령 정리
- 간단한 서비스 구축까지 진행
- ansible 등을 통한 설치 자동화

- 도커 기반 msa서비스 구축진행
    1. Spring boot API
    2. react view 
    3. DB 

- Docker -> K8s 진행
    
### Docker Install 

https://docs.docker.com/install/

### Install Postgres
```bash
[svr]$ docker pull postgres
[svr]$ docker volume create mypgdata
[svr]$ docker run -d -p 5432:5432 --name pgsql -it --rm -v mypgdata:/var/lib/postgresql/data -e POSTGRES_PASSWORD=password postgres
[svr]$ docker exec -it pgsql psql -U postgres
postgres=# CREATE USER ndays WITH ENCRYPTED PASSWORD 'ndays';
postgres=# \du
postgres=# CREATE DATABASE ndays OWNER ndays ENCODING 'utf-8';
postgres=# \l
postgres=# \c ndays
```

## Features
## Usage 
## Documentation 
## Tests 

---
