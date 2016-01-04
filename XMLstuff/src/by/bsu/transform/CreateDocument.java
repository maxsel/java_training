package by.bsu.transform;

import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateDocument {
    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder =
                    documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = documentBuilder.newDocument();
        String root = "book";
        Element rootElement = document.createElement(root);
        document.appendChild(rootElement);
        for (int i = 0; i < 1; i++) {
            String elementName = "name";
            Element emName = document.createElement(elementName);
            String name = "Technique Java";
            emName.appendChild(document.createTextNode(name));
            String elementAuthor = "author";
            Element emAuthor = document.createElement(elementAuthor);
            String author = "Blinov";
            emAuthor.appendChild(document.createTextNode(author));
            emAuthor.setAttribute("id", "3");
            rootElement.appendChild(emName);
            rootElement.appendChild(emAuthor);
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileWriter("data/book.xml"));
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}