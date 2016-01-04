package by.bsy.saxsimple;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class SimpleStudentHandler extends DefaultHandler {
    private static int e;
    private static int c;
    @Override
    public void startDocument() {
        System.out.println("Parsing started");
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        String s = "<" + localName + String.format("(%d) ", e++);

        // получение и вывод информации об атрибутах элемента
        for (int i = 0; i < attrs.getLength(); i++) {
            s += attrs.getLocalName(i) + "=\"" + attrs.getValue(i) + "\" ";
        }
        s = s.trim() +  ">";
        System.out.print(s);
    }
    @Override
    public void characters(char[ ] ch, int start, int length) {
        //System.out.print(new String(ch, start, length));
        System.out.print(String.format("CHARS[[[%s]]]", new String(ch, start, length)));
    }
    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.print("</" + localName + ">");
    }
    @Override
    public void endDocument() {
        System.out.println("\nParsing ended");
    }
}