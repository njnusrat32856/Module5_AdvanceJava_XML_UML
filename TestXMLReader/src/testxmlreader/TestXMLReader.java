package testxmlreader;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestXMLReader {

    public static void main(String[] args) {
        System.out.println("XML Reader");

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();
            
            Document document = builder.parse("student.xml");
            
            document.getDocumentElement().normalize();
            
            // Get the Root element
            Element root = document.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());
            
            // Get all student nodes
            NodeList nodeList = document.getElementsByTagName("student");
            
            for(int i= 0; i < nodeList.getLength(); i++){
                
                Node node = nodeList.item(i);
                
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    
                    String id = element.getElementsByTagName("id").item(0).getTextContent();
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String position = element.getElementsByTagName("position").item(0).getTextContent();
                    String address = element.getElementsByTagName("address").item(0).getTextContent();
                    
                    System.out.println("Student ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Position: " + position);
                    System.out.println("Address: " + address);
                    System.out.println("--------------------------");
                }
            }
            
        } catch (SAXException ex) {
            Logger.getLogger(TestXMLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestXMLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TestXMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
