package by.bsu.parsing;

import java.math.BigInteger;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import by.bsu.xmlstudents.Address;
import by.bsu.xmlstudents.Student;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class StudentHandler extends DefaultHandler {

    private Set<Student> students;

    private Student current = null;

    private StudentEnum currentEnum = null;

    private EnumSet<StudentEnum> withText;

    public StudentHandler() {
        students = new HashSet<Student>();
        withText = EnumSet.range(StudentEnum.NAME, StudentEnum.STREET);
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("student".equals(localName)) {
            current = new Student();
            current.setAddress(new Address());
            current.setLogin(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                current.setFaculty(attrs.getValue(1));
            }
        } else {
            StudentEnum temp = StudentEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("student".equals(localName)) {
            students.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    current.setName(s);
                    break;
                case TELEPHONE:
                    //current.setTelephone(Integer.parseInt(s));
                    current.setTelephone(new BigInteger(s));
                    break;
                case STREET:
                    current.getAddress().setStreet(s);
                    break;
                case CITY:
                    current.getAddress().setCity(s);
                    break;
                case COUNTRY:
                    current.getAddress().setCountry(s);
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}