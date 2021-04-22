package com.mongodb;

import com.mongodb.client.*;

import static com.mongodb.client.model.Accumulators.*;
import static com.mongodb.client.model.Aggregates.*;

import com.mongodb.client.model.Accumulators;
import org.bson.Document;

import java.util.Arrays;

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

        AggregateIterable outputPipeline = useCollection.aggregate(Arrays.asList(
//                unwind(""),
                match(new Document("state","TX")),
                group("$city", Accumulators.sum("totalPop","$pop")),
                project(new Document("_id",0)),
                sort(new Document("totalPop",-1)),
                limit(3)
//                sort(new Document("zip",-1))
        ));

        for (Object dbObject : outputPipeline)
        {
            System.out.println(dbObject);
        }

    }
}
