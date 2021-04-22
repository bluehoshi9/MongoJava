package com.mongodb;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Collection {

    public static void main(String[] args) {
//        CONNECTION
        MongoClient mongoClient = MongoClients.create("mongodb://localhost/27017");
        System.out.println(">Connect successfully");

//        USE DATABASE
        String databaseName = "ResManagement";
        MongoDatabase useDB = mongoClient.getDatabase(databaseName);
        System.out.println(">Using database \"" + databaseName + "\"");

//        CREATE COLLECTION
//        String collectionCreate = "test5";
//        useDB.createCollection(collectionCreate);
//        System.out.println(">Create collection \"" + collectionCreate +"\" successfully");

//        CREATE MULTIPLE COLLECTION
//        useDB.createCollection("collectionCreate1");
//        useDB.createCollection("collectionCreate2");
//        useDB.createCollection("collectionCreate3");
//        useDB.createCollection("collectionCreate4");

//        DROP COLLECTION
//        String collectionDrop = "test2";
//        useDB.getCollection(collectionDrop).drop();
//        System.out.println(">Drop collection \"" + collectionDrop +"\" successfully");

//        DROP MULTIPLE COLLECTIONS
//        useDB.getCollection("collectionDrop1").drop();
//        useDB.getCollection("collectionDrop2").drop();
//        useDB.getCollection("collectionDrop3").drop();
//        useDB.getCollection("collectionDrop4").drop();
//        useDB.getCollection("collectionDrop5").drop();

//        LIST COLLECTIONS
        System.out.println(">Listing All Collections Of \"" + databaseName + "\"");
        for (String t: useDB.listCollectionNames()) {
            System.out.println(t);
        }
    }
}
