package com.mongodb;

import com.mongodb.client.*;

import org.bson.Document;

import java.util.Arrays;

import static com.mongodb.client.model.Aggregates.*;

public class Aggregation {
    public static void main(String[] args) {
//        CONNECTION
        MongoClient mongoClient = MongoClients.create("mongodb+srv://nhuttruong:nhuttruong@firsttest.sngeo.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        System.out.println(">Connect successfully");

//        USE DATABASE
        String databaseName = "sample_training";
        MongoDatabase useDB = mongoClient.getDatabase(databaseName);
        System.out.println(">Using database \"" + databaseName + "\"");

//        GET COLLECTION
        MongoCollection<Document> useCollection = useDB.getCollection("zips");

//        AGGREGATION PIPELINE
        AggregateIterable outputPipeline = useCollection.aggregate(Arrays.asList(
                match(new Document("state","TX")),
                project(new Document("_id",0).append("city",1).append("pop",1)),
                sort(new Document("pop",-1)),
                limit(10)
//                group("$state",Accumulators.sum("cityNum",1))
//                sort(new Document("cityNum", 1))
        ));

        for (Object dbObject : outputPipeline) {
            System.out.println(dbObject);
        }

    }
}

