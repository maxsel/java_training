package by.epam.selyuk.taxistation.utility;

public class IdGenerator {
    private static int id = 0;

    private IdGenerator() {
    }

    public static int generate() {
        return ++id;
    }
}
