package com.ingester.mongodb.client;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;

/**
 * 
 * @author ilariacorda
 * @version 1.0
 * @since 2017-10
 *
 */


public class MongoDB_DAO implements MongoDB_DAO_Interface {

    private MongoClient client;
    private MongoDatabase db;

    private String busStopCollectionName;

    private static final transient Logger LOG = LoggerFactory.getLogger(MongoDB_DAO.class);
   
    public MongoDB_DAO(String server, int port, String dbName, String user, String password) throws UnknownHostException {

        LOG.debug("Opening MongoDB : " + server + " / " + port + " / " + dbName);
        openMongoDBconn(server, port, user, password);
        db = get_DB(dbName);
    }

    /*
     * Extra constructor used in the individual test classes for the xml processors
     */
    public MongoDB_DAO(MongoClient client, String dbName){
        LOG.debug("Opening MongoDB : " + client + " / " + dbName + " / ");
        this.client = client;
        db = get_DB(dbName);
    }

    private MongoDatabase get_DB(String dbName) {

        return client.getDatabase(dbName);
    }

    @Override
    public void setBusStopCollection(String collName) {

        busStopCollectionName = collName;
    }

    @Override
    public void openMongoDBconn(String server, int port, String user, String password) {

        String mongoClientURI = null;

        if (user != null) {
            mongoClientURI = "mongodb://" + user + ":" + password + "@" + server + ":" + port;
        }
        else {
            mongoClientURI = "mongodb://" + server + ":" + port;
        }

        MongoClientURI connectionString = new MongoClientURI(mongoClientURI);
        client = new MongoClient(connectionString);

    }

    @Override
    public void closeMongoDBconn() {

        client.close();
    }

    @Override
    public void upsertBusStopJson(Document doc) throws MongoException {

        Bson filter = Filters.eq("bus stop id", doc.get("bus stop id"));
        Bson update =  new Document("$set", doc);
        db.getCollection(busStopCollectionName).updateOne(filter, update, new UpdateOptions().upsert(true));
    }
}
