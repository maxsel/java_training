package by.bsu.domparsing;

import by.bsu.xmlstudents.Student;

import java.util.Set;

/**
 * Created by Maxim Selyuk on 04.01.16.
 */
public class StudentDOMMain {
    public static void main(String[] args) {
        StudentsDOMBuilder domBuilder = new StudentsDOMBuilder();
        domBuilder.buildSetStudents("data/students.xml");
        System.out.println(domBuilder.getStudents());
        Set<Student> st = domBuilder.getStudents();
        for (Student s : st) {
            System.out.println(
                    s.getLogin() + " " + s.getFaculty() + " " + s.getName() + " " + s.getTelephone() + " " +
                            s.getAddress().getCountry() + " " + s.getAddress().getCity() + " " +  s.getAddress().getStreet());
        }
    }
}
