package org.jboss.modules.test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.events.DTD;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;

import org.w3c.dom.Document;

public class JAXPCaller {

    public Document document() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            return factory.newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException();
        }
    }

    public DocumentBuilderFactory documentFactory() {
        return DocumentBuilderFactory.newInstance();
    }

    public DocumentBuilder documentBuilder() {
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException();
        }
    }

    public SAXParserFactory saxParserFactory() {
        return SAXParserFactory.newInstance();
    }

    public SAXParser saxParser() {
        try {
            return SAXParserFactory.newInstance().newSAXParser();
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    public TransformerFactory transformerFactory() {
        return TransformerFactory.newInstance();
    }

    public Transformer transformer() {
        try {
            return transformerFactory().newTransformer();
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    public TransformerHandler transformerHandler() {
        try {
            return ((SAXTransformerFactory)transformerFactory()).newTransformerHandler();
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    public XMLEventFactory eventFactory() {
        return XMLEventFactory.newInstance();
    }

    public DTD eventDTD() {
        try {
            return eventFactory().createDTD("blah");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public XMLInputFactory inputFactory() {
        return XMLInputFactory.newInstance();
    }

    public String inputProperty() {
        return String.valueOf(inputFactory().getProperty("javax.xml.stream.reporter"));
    }

    public XMLOutputFactory outputFactory() {
        return XMLOutputFactory.newInstance();
    }

    public String outputProperty() {
        return String.valueOf(outputFactory().getProperty("javax.xml.stream.isRepairingNamespaces"));
    }

    public DatatypeFactory datatypeFactory() {
        try {
            return DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            throw new IllegalStateException();
        }
    }

    public Duration duration() {
        return datatypeFactory().newDuration(1);
    }

    public static void main(String[] args) {
        // for main test, do nothing
    }
}
