package com.dev.med.siboback.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
@Getter
@Setter
public class PersistenceMongoConfig extends AbstractPersistenceMongoConfig {

    public PersistenceMongoConfig() {
    }

    public MongoClient mongoClient() {
        MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017/sibo");
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://127.0.0.1:27017"));
        return mongoClient;
    }
}
