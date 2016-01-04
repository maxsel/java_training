package by.bsu.allparsers;

import by.bsu.xmlstudents.Student;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractStudentsBuilder {
    // protected так как к нему часто обращаются из подкласса
    protected Set<Student> students;
    public AbstractStudentsBuilder() {
        students = new HashSet<>();
    }
    public AbstractStudentsBuilder(Set<Student> students) {
        this.students = students;
    }
    public Set<Student> getStudents() {
        return students;
    }
    abstract public void buildSetStudents(String fileName);
}
