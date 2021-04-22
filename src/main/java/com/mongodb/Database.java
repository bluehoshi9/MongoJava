package com.mongodb;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Database {

    public static void main(String[] args) {
//        CONNECTION
        MongoClient mongoClient = MongoClients.create("mongodb://localhost/27017");
        System.out.println(">Connect successfully");

//        CREATE DATABASE = Use Database and Create One Collection
//        String databaseCreate = "databaseName";
//        String collectionCreate = "collectionName";
//        MongoDatabase useDB = mongoClient.getDatabase(databaseCreate);
//        useDB.createCollection(collectionCreate);
//        System.out.println(">Create database \"" + databaseCreate + "\" with collection \"" + collectionCreate + "\"");

//        DROP DATABASE
//        String databaseDrop = "databaseName";
//        MongoDatabase useDB = mongoClient.getDatabase(databaseDrop);
//        useDB.drop();
//        System.out.println(">Drop database \"" + databaseDrop + "\" successfully");

//        LIST DATABASE
        System.out.println(">Listing All Database");
        for (String t : mongoClient.listDatabaseNames()) {
            System.out.println(t);
        }
    }
}
