package by.bsu.parsing;

import by.bsu.xmlstudents.Student;

import java.util.Set;

/**
 * Created by Maxim Selyuk on 04.01.16.
 */
public class StudentSAXMain {
    public static void main(String[] args) {
        StudentsSAXBuilder saxBuilder = new StudentsSAXBuilder();
        saxBuilder.buildSetStudents("data/students.xml");
        System.out.println(saxBuilder.getStudents());
        Set<Student> st = saxBuilder.getStudents();
        for (Student s : st) {
            System.out.println(
                    s.getLogin() + " " + s.getFaculty() + " " + s.getName() + " " + s.getTelephone() + " " +
                    s.getAddress().getCountry() + " " + s.getAddress().getCity() + " " +  s.getAddress().getStreet());
        }
    }
}
