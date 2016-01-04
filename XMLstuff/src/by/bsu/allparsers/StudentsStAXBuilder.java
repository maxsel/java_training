package by.bsu.allparsers;

import by.bsu.xmlstudents.Student;
import javax.xml.stream.XMLInputFactory;
import java.util.Set;

public class StudentsStAXBuilder extends AbstractStudentsBuilder {
    private XMLInputFactory inputFactory;

    public StudentsStAXBuilder() {
        // more code
    }

    public StudentsStAXBuilder (Set<Student> students) {
        super(students);
        // more code
    }

    @Override
    public void buildSetStudents(String fileName) {
        // more code
    }
}
