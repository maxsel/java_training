package by.bsu.allparsers;

/**
 * Created by Maxim Selyuk on 04.01.16.
 */
public class Main {
    public static void main(String[] args) {
        StudentBuilderFactory sFactory = new StudentBuilderFactory();
        AbstractStudentsBuilder builder = sFactory.createStudentBuilder("stax");
        builder.buildSetStudents("data/students.xml");
        System.out.println(builder.getStudents());
    }
}
