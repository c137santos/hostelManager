# Laboratório de Banco de Dados III 

Professor Bertoti

## Atividade I 

Está na pasta atividadeI com as chamadas da API
Além disso, foi desenhado lá o hostelManagerSystemApplication.java que foi solicitado como CRUD.

## Atividade II

Disciplina de Laboratório de Banco de Dados III, ministrada pelo professor Bertoti. 

Esta é a Atividade I - Criar uma API utilizando Spring Boot.

O 1º código foi a estrutura básica entregue pelo jar, mais esse código base para API


## Setup

1. Certifique-se de ter o Java Development Kit (JDK) 17 instalado em sua máquina. Você pode baixar o JDK [aqui](https://www.oracle.com/java/technologies/javase-downloads.html).

2. Instale o Maven, que é a ferramenta de build utilizada pelo Spring Boot. Você pode seguir as instruções de instalação [aqui](https://maven.apache.org/install.html).

3. Clone este repositório em sua máquina local:
    ```sh
    git clone <URL_DO_REPOSITORIO>
    ```

4. Navegue até o diretório do projeto:
    ```sh
    cd <DIRETORIO_DO_PROJETO>
    ```

## Executando a API

Para executar a API durante o desenvolvimento, utilize o seguinte comando no terminal:
```sh
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`.


## Gerando o JAR

O primeiro JAR foi gerado pelo site [Spring Initializr](https://start.spring.io/) com a dependência de web já adicionada.

Para atualizar o JAR, siga os passos abaixo:

1. Faça as modificações necessárias no código fonte do projeto.

2. Navegue até o diretório do projeto no terminal.

3. Execute novamente o comando Maven para compilar o projeto e gerar o novo JAR:
    ```sh
    mvn clean package
    ```

4. O novo arquivo JAR será gerado no diretório `target`.

```
java -jar target/hostel-manager-0.0.1-SNAPSHOT.jar

```# hostelManager
