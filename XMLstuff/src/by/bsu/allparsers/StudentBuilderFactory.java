package by.bsu.allparsers;

public class StudentBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }
    public AbstractStudentsBuilder createStudentBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new StudentsDOMBuilder();
            case STAX:
                return new StudentsStAXBuilder();
            case SAX:
                return new StudentsSAXBuilder();
            default:
                throw new EnumConstantNotPresentException (type.getDeclaringClass(), type.name());
        }
    }
}