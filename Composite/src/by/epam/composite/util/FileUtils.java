package by.epam.composite.util;

import by.epam.composite.exception.ReadFileException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Maxim Selyuk on 16.12.15.
 */
public class FileUtils {
    public static String readFile(String path) throws ReadFileException {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded, Charset.defaultCharset());
        } catch (IOException e) {
            throw new ReadFileException(e);
        }
    }
}
