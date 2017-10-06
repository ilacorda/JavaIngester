package com.ingester.xml;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 
 * @author ilariacorda
 * @version 1.0
 * @since 2017-10
 */
public interface XML_Processor {

    default void process(Path inputFile)
            throws ParserConfigurationException, SAXException, IOException {

        DefaultHandler defaultHandler = new DefaultHandler();

        SAXParserFactory parserFactor = SAXParserFactory.newInstance();
        SAXParser parser = parserFactor.newSAXParser();

        ZipFile zip = new ZipFile( inputFile.toFile() );
        Enumeration<? extends ZipEntry> files = zip.entries();
        while (files.hasMoreElements()) {
            ZipEntry entry = files.nextElement();
            InputStream xmlStream = zip.getInputStream( entry );
            parser.parse( xmlStream, defaultHandler );
            xmlStream.close();
        }

        zip.close();
    }
}
