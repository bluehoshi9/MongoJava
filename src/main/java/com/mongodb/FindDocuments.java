package com.mongodb;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FindDocuments {

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

//        FIND ALL DOCUMENTS
//        FindIterable<Document> iterDoc = useCollection.find();
//        Iterator<Document> it = iterDoc.iterator();
//        System.out.println(">All Documents");
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

//        FIND DOCUMENT WITH FILTER
//        FindIterable<Document> iterDoc = useCollection.find(Filters.eq("name", "Ram"));
//        Iterator<Document> it = iterDoc.iterator();
//
//        System.out.println(">Find with filter");
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

//        FIND DOCUMENT WITH CONDITION
        FindIterable<Document> iterDoc = useCollection.find(
                Filters.and(Filters.gt("age", 25), Filters.regex("name", "a")));
        Iterator<Document> it = iterDoc.iterator();

        System.out.println(">Find with condition");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
