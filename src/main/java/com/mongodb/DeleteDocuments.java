package com.mongodb;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class DeleteDocuments {

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

//        DELTE ONE DOCUMENT WITH FILTER
        useCollection.deleteOne(Filters.and(Filters.eq("name", "Teo"),Filters.eq("age", 200)));
        System.out.println(">Delete ONE document successfully");

//        DELTE MULTIPLE DOCUMENTS WITH FILTER
//        DeleteResult result  = useCollection.deleteMany(Filters.eq("name", "Ram"));
//        System.out.println(">Delete documents successfully");
//        System.out.println(">The Numbers of Deleted Document(s) : " + result.getDeletedCount());

//        DELETE ALL
//        useCollection.deleteMany(new BasicDBObject());
//        System.out.println(">Delete all documents successfully");
    }
}
