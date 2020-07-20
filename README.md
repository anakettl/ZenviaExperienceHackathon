![Java CI with Gradle](https://github.com/anakettl/ZenviaExperienceHackathon/workflows/Java%20CI%20with%20Gradle/badge.svg)
# ZenviaExperienceHackathon

----

Projeto desenvolvido para o ZenviaExperienceHackathon

----

## Versões

- [Java 14](https://computingforgeeks.com/install-oracle-java-openjdk-14-on-ubuntu-debian-linux/)
- [PostgreSQL 12](https://www.postgresql.org/download/)
- Gradle 6.3
- [Git SCM](https://git-scm.com/download/linux)

- Obs .: O gradle está incorporado no projeto e não requer instalação.

----

## Configurando banco de dados local

 Veja o arquivo [application-dev.yml](https://github.com/anakettl/ZenviaExperienceHackathon/ZenviaExperienceHackathon) para definir usuário e senha

Você precisará criar um banco de dados vazio antes de iniciar a aplicação. O nome do banco padrão é backend (veja o arquivo de configuração mencionado anteriormente). Para criá-lo, execute:

```sh
sudo -u postgres psql -c 'CREATE DATABASE assembly'
```

----

## Postgres no Docker

Caso não queira instalar o Postgres na sua máquina, é possível utilizá-lo via Docker:

1. Crie estas pastas:

```sh
mkdir -p docker/postgres
```

2. Instale o Docker via Snap:

```sh
sudo snap install docker
```

Se você não tiver o snap instalado, execute esse comando no terminal:

```sh
sudo apt update
sudo apt install snapd
```

3. Crie e inicie o container (Substitua {user} pelo seu usuário:) :

```sh
sudo docker run -d --name postgres12 -e POSTGRES_PASSWORD=root -e POSTGRES_DB=backend -e PGDATA=/var/lib/postgresql/data/pgdata -v /home/{user}/docker/postgres:/var/lib/postgresql/data postgres --add-host postgres12
```

----

## Após instalar e configurar as dependecias para executar o projeto, faça os seguintes passos


1. Abra um terminal e rode este comando para baixar o projeto:
```sh
git clone https://github.com/anakettl/ZenviaExperienceHackathon.git
```

2. Entre na pasta do projeto:
```sh
cd ./ZenviaExperienceHackathon
```

3. Dentro da pasta do projeto rode este comando para iniciar a aplicação:
```sh
./gradlew bootRun
```

## Rotas da API
https://zenvia-exp-hackathon-backend.herokuapp.com/swagger-ui.html#/
