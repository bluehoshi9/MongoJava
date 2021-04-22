package com.mongodb;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class UpdateDocuments {

    public static void main(String[] args) {
//        CONNECTION
        MongoClient mongoClient = MongoClients.create("mongodb://localhost/27017");
        System.out.println(">Connect successfully");

//        USE DATABASE
        String databaseName = "databaseName";
        MongoDatabase useDB = mongoClient.getDatabase(databaseName);
        System.out.println(">Using database \"" + databaseName + "\"");

//        GET COLLECTION
        MongoCollection<Document> useCollection = useDB.getCollection("collectionName");

//        UPDATE ONE DOCUMENT
//        useCollection.updateOne(Filters.eq("name", "Ram"), Updates.set("age", 100));
//        System.out.println(">Update ONE document successfully");

//        UPDATE MULTIPLE DOCUMENTs
        useCollection.updateMany(Filters.eq("name", "Ram"), Updates.set("age", 200));
        System.out.println(">Update documents successfully");
    }
}
