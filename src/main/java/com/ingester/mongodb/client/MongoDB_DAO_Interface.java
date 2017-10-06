package com.ingester.mongodb.client; 

import com.mongodb.MongoException;
import org.bson.Document;

import java.util.ArrayList;

/**
 * This is the interface for the MongoDB DAO
 * @author ilariacorda
 * @version 1.0
 * @since 2017-10
 *
 */

public interface MongoDB_DAO_Interface {
    
    void setBusStopCollection(String collName);

    void openMongoDBconn(String server, int port, String user, String password);

    void closeMongoDBconn();

    void upsertBusStopJson(Document doc) throws MongoException;

}
