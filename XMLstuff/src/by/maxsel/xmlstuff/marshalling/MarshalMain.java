package by.maxsel.xmlstuff.marshalling;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import by.maxsel.xmlstuff.entity.*;

public class MarshalMain {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Gems.class);
            Marshaller m = context.createMarshaller();
            Gems st = UnMarshalWithXSD.unmarshal();                 //
            m.marshal(st, new FileOutputStream("data/gems2.xml"));
            //m.marshal(st, System.out); // копия на консоль
            System.out.println("XML-файл создан");
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        } catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }
    }
}