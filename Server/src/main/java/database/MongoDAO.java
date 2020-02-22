package database;

import com.mongodb.Block;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class MongoDAO implements  DAO {
    @Override
    public boolean doPost(File file) {
        return false;
    }

    @Override
    public File doGet(String fileName) {
        return null;
    }

    @Override
    public String doCheckCurrentHashCodeOfFile(File file) {
        return null;
    }

    @Override
    public String doCheckCurrentHashCodeOfFile(String fileName) {
        return null;
    }

    public void todo(){
        MongoClient mongoClient = MongoClients.create("mongodb://hostOne:27017,hostTwo:27018");
        MongoDatabase database = mongoClient.getDatabase("mydb");
        MongoCollection<Document> collection = database.getCollection("test");

        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));
        collection.insertOne(doc);

        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < 100; i++) {
            documents.add(new Document("i", i));
        }
        collection.insertMany(documents);

        System.out.println(collection.countDocuments());

        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());

        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        myDoc = collection.find(eq("i", 71)).first();
        System.out.println(myDoc.toJson());

        Block<Document> printBlock = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        };

        collection.find(gt("i", 50)).forEach(printBlock);
        collection.find(and(gt("i", 50), lte("i", 100))).forEach(printBlock);
        collection.updateOne(eq("i", 10), new Document("$set", new Document("i", 110)));
        collection.deleteOne(eq("i", 110));

        DeleteResult deleteResult = collection.deleteMany(gte("i", 100));
        System.out.println(deleteResult.getDeletedCount());
    }
}
