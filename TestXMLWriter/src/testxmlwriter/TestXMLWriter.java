
package testxmlwriter;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TestXMLWriter {

    public static void main(String[] args) {
        System.out.println("XML writer");
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            Document document = builder.newDocument();
            
            Element root = document.createElement("company");
            document.appendChild(root);
            
            Element employee1 = document.createElement("employee");
            root.appendChild(employee1);
            
            Element id1 = document.createElement("id");
            id1.appendChild(document.createTextNode("1"));
            employee1.appendChild(id1);
            
            Element name1 = document.createElement("name");
            name1.appendChild(document.createTextNode("Nusrat Jahan"));
            employee1.appendChild(name1);
            
            Element position1 = document.createElement("position");
            position1.appendChild(document.createTextNode("Software Engineer"));
            employee1.appendChild(position1);
            
            Element salary1 = document.createElement("salary");
            salary1.appendChild(document.createTextNode("30000"));
            employee1.appendChild(salary1);
            
            Element employee2 = document.createElement("employee");
            root.appendChild(employee2);
            
            Element id2 = document.createElement("id");
            id2.appendChild(document.createTextNode("2"));
            employee2.appendChild(id2);
            
            Element name2 = document.createElement("name");
            name2.appendChild(document.createTextNode("Subaita Khanom"));
            employee2.appendChild(name2);
            
            Element position2 = document.createElement("position");
            position2.appendChild(document.createTextNode("Software Engineer"));
            employee2.appendChild(position2);
            
            Element salary2 = document.createElement("salary");
            salary2.appendChild(document.createTextNode("50000"));
            employee2.appendChild(salary2);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            
            Transformer transformer = transformerFactory.newTransformer();
            
            DOMSource source = new DOMSource(document);
            
            StreamResult result = new StreamResult(new File("output.xml"));
            
            transformer.transform(source, result);
            
            System.out.println("XML file created successfully!");
            
        } catch (ParserConfigurationException | TransformerException ex) {
            ex.printStackTrace();
            Logger.getLogger(TestXMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        } 
//        catch (TransformerConfigurationException ex) {
//            Logger.getLogger(TestXMLWriter.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        catch (TransformerException ex) {
//            Logger.getLogger(TestXMLWriter.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
}
