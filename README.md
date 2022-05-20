# CrudContato
**Clonando o repositório**

    git clone https://github.com/joaoleao87/CrudContato.git
 
**Entando na pasta**

    cd CrudContato
  
**Iniciando a aplicação com o docker-compose**

    docker-compose up -d 
  
**Como configurei a aplicação**

- Configurando a comunicação do banco
  
      spring.datasource.url=jdbc:mariadb://crud:3306/crud?createDatabaseIfNotExist=true
      spring.datasource.username=root
      spring.datasource.password=root
      spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=false
      spring.jpa.generate-ddl=true
    
- Criando o arquivo jar
    
      mvn clean install

**Como configurei o dockerfile** 

    FROM openjdk
    
    #Faz a copia do arquivo jar que permitirá que a aplicação inicie
    COPY  target/CrudContato-0.0.1-SNAPSHOT.jar /usr/local/CrudContato-0.0.1-SNAPSHOT.jar
    
    #Porta onde a aplicação irá rodar
    EXPOSE 8080
    
    #Diretório do container
    WORKDIR /usr/local
    
    #Configura o que será executado quando o container for iniciado
    ENTRYPOINT [ "java", "-jar", "CrudContato-0.0.1-SNAPSHOT.jar" ]


**Como configurei o docker-compose**

    version: '3'
    
    #Configurações das imagens que serão iniciadas com o docker-compose 
    
    services:
    
    #Configurações do mariadb 
    
      crud:
      #imagem que do banco
        image: mariadb:latest
        container_name: crud
        restart: always
        #Configurações da senha do usuario root
        environment:
          MYSQL_ROOT_PASSWORD: root

    #configurações da aplicação java
    
      crudapp:
      #local da aplicação
        build: "./"
        container_name: crudapp
        restart: always
        ports:
         - "8080:8080"
      #configurando a imagem para rodar após o banco
        depends_on:
         - crud
