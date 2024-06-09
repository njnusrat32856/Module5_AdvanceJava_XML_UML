package testxml;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class TestXML {

    public static void main(String[] args) {
        System.out.println("XML \n Accessing a SAX Parser.");

        SAXParserFactory saxpf = SAXParserFactory.newInstance();
        
//        saxpf.setNamespaceAware(true);
//        saxpf.setValidating(true);

        System.out.println("Parser will " + (saxpf.isNamespaceAware() ? "" : "not ")
                + "be namespace aware");
        
        System.out.println("Parser will " + (saxpf.isValidating()? "" : "not ")
                + "validate XML");
        
        SAXParser parser = null;
        
        try {
            parser = saxpf.newSAXParser();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TestXML.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
            
        } catch (SAXException ex) {
            Logger.getLogger(TestXML.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
            
        }
        System.out.println("Parser object is: " + parser);
    }

}
