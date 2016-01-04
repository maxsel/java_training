package by.bsu.allparsers;

import by.bsu.xmlstudents.Student;
import javax.xml.parsers.DocumentBuilder;
import java.util.Set;

public class StudentsDOMBuilder extends AbstractStudentsBuilder {
    private DocumentBuilder docBuilder;

    public StudentsDOMBuilder() {
        // more code
    }

    public StudentsDOMBuilder (Set<Student> students) {
        super(students);
        // more code
    }

    @Override
    public void buildSetStudents(String fileName) {
        // more code
    }
}
