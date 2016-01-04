package by.bsu.allparsers;

import by.bsu.xmlstudents.*;
import by.bsu.parsing.*;
import org.xml.sax.XMLReader;
import java.util.Set;

public class StudentsSAXBuilder extends AbstractStudentsBuilder {
    private StudentHandler sh;
    private XMLReader reader;

    public StudentsSAXBuilder() {
        // more code
    }

    public StudentsSAXBuilder (Set<Student> students) {
        super(students);
        // more code
    }

    @Override
    public void buildSetStudents(String fileName) {
    // more code
    }
}