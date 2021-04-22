package com.mongodb;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class InsertDocuments {

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

//        PREPARING A DOCUMENT + INSERT ONE DOCUMENT INTO COLLECTION
//        Document person = new Document();
//        person.append("name", "Ram");
//        person.append("age", 256);
//        person.append("city", "Hyderabad");
//
//        useCollection.insertOne(person);
//        System.out.println(">Document inserted successfully");

//        PREPARE MULTIPLE DOCUMENTS + INSERT MULTIPLE DOCUMENTS
        Document document1 = new Document("name", "Ram").append("age", 26).append("city", "Hyderabad");
        Document document2 = new Document("name", "Robert").append("age", 27).append("city", "Vishakhapatnam");
        Document document3 = new Document("name", "Rhim").append("age", 30).append("city", "Delhi");

        List<Document> listDoc = new ArrayList<Document>();
        listDoc.add(document1);
        listDoc.add(document2);
        listDoc.add(document3);
        useCollection.insertMany(listDoc);
        System.out.println(">Documents inserted successfully");
    }
}
