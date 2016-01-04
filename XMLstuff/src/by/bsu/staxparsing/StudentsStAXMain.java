package by.bsu.staxparsing;

import by.bsu.xmlstudents.Student;

import java.util.Set;

/**
 * Created by Maxim Selyuk on 04.01.16.
 */
public class StudentsStAXMain {
    public static void main(String[] args) {
        StudentsStAXBuilder staxBuilder = new StudentsStAXBuilder();
        staxBuilder.buildSetStudents("data/students.xml");
        System.out.println(staxBuilder.getStudents());
        Set<Student> st = staxBuilder.getStudents();
        for (Student s : st) {
            System.out.println(
                    s.getLogin() + " " + s.getFaculty() + " " + s.getName() + " " + s.getTelephone() + " " +
                            s.getAddress().getCountry() + " " + s.getAddress().getCity() + " " +  s.getAddress().getStreet());
        }
    }
}
