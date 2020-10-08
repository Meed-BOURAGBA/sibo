package com.dev.med.siboback.data.impl;

import com.dev.med.siboback.config.PersistenceMongoConfig;
import com.dev.med.siboback.data.UserDao;
import com.dev.med.siboback.entities.users.User;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UserDaoImpl implements UserDao {


    @Override
    public String addNewUser(User user) {
        PersistenceMongoConfig persistenceMongoConfig = new PersistenceMongoConfig();
            user.setCle(UUID.randomUUID().toString());
            Document doc = new Document();
            doc.append("name", user.getName());
            doc.append("firstName", user.getFirstName());
            doc.append("role", user.getRole());
            doc.append("email", user.getEmail());
            doc.append("cle", user.getCle());

        persistenceMongoConfig.mongoClient().getDatabase("sibo").
                getCollection("Users").insertOne(doc);
        return user.getCle();
    }

    @Override
    public List<User> getUsers() {
        PersistenceMongoConfig persistenceMongoConfig = new PersistenceMongoConfig();
        List<User> userList = new ArrayList<>();
        MongoCollection<Document> collection = persistenceMongoConfig.mongoClient().getDatabase("sibo").getCollection("Users");
        for (Document doc : collection.find()) {

            User user = new User();
            user.setCle(doc.get("cle").toString());
            user.setName(doc.get("name").toString());
            user.setFirstName(doc.get("firstName").toString());
            user.setRole(doc.get("role").toString());
            user.setEmail(doc.get("email").toString());
            userList.add(user);
        }
        return userList;
    }

}
