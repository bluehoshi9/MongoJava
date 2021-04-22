package com.mongodb;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    public static void main(String[] args) {
//        CONNECTION
        MongoClient mongoClient = MongoClients.create("mongodb://localhost/27017");
        System.out.println(">Connect successfully");

//        USE DATABASE
        String databaseName = "documentName";
        MongoDatabase useDB = mongoClient.getDatabase(databaseName);
        System.out.println(">Using database \"" + databaseName + "\"");

//         CREATE A NEW USER
        Document command = new Document("createUser", "usr4")
                .append("pwd", "123")
                .append("roles", Collections.singletonList("readWrite"));

        useDB.runCommand(command);
        System.out.println(">Add User Successfully");

//         LIST ALL USERS IN DATABASE
        System.out.println(">List All Users Of Database" + databaseName);
        Document response = useDB.runCommand(new Document("usersInfo", 1));
        List<Document> users = response.get("users", List.class);
        for (Document user : users) {
            System.out.println(user);
        }
    }
}
