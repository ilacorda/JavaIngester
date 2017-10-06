package com.ingester.xml; 

import com.mongodb.MongoException;
import com.ingester.mongodb.client.*;
import com.ingester.objectDefinition.BusStop;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by DHorner on 31/05/2016.
 */
public class BusStopProcessor extends DefaultHandler implements XML_Processor {

    private static final transient Logger LOG = LoggerFactory.getLogger( BusStopProcessor.class );
    private BusStop busStop = null;
    private StringBuffer text = new StringBuffer();
    private MongoDB_DAO mongo = null;
    private Document newJSON = new Document();


    public BusStopProcessor(MongoDB_DAO mongo) {
        this.mongo = mongo;
    }

    @Override
    // A start tag is encountered.
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        text = new StringBuffer();

        switch (qName.toUpperCase()) {

            // Create a new Bus Stop.
            case "STOP_POINT": {
                busStop = new BusStop();
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName.toUpperCase()) {
            case "STOP_POINT": {
                // The end tag of the bus stop's data was encountered, so add the bus stop to the list.
                LOG.debug( "found bus stop : " + busStop.toString() );

                // build JSON document and write to MongoDB
                newJSON.clear();
                appendToJSON( "bus stop id", busStop.getCode(), newJSON );
                appendToJSON( "bus stop name", busStop.getName(), newJSON );
                appendToJSON( "bus stop lat", busStop.getLatitude(), newJSON );
                appendToJSON( "bus stop long", busStop.getLongitude(), newJSON );
                LOG.debug( "writing JSON object" );

                try {
                    mongo.upsertBusStopJson( newJSON );
                } catch (MongoException me) {
                    throw new SAXException( me );
                }

                break;
            }
            case "STOP_CODE_LBSL": {
                busStop.setCode( text.toString() );
                break;
            }
            case "STOP_NAME": {
                busStop.setName( text.toString() );
                break;
            }
            case "LOCATION_LATITUDE": {
                busStop.setLatitude( text.toString() );
                break;
            }
            case "LOCATION_LONGITUDE": {
                busStop.setLongitude( text.toString() );
                break;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append( String.copyValueOf( ch, start, length ).trim() );
    }


    private void appendToJSON(String key, String value, Document jsonDoc) {

        jsonDoc.append( key, value );
    }

}

