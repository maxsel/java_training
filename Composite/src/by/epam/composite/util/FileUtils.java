package by.epam.composite.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by maxsel on 16.12.15.
 */
public class FileUtils {
    /*
    example:
                // (or: StandardCharsets.UTF_8)
                String text = FileUtils.readFile("./resources/text.txt", Charset.defaultCharset());
     */
    public static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    /*
    example:
                FileUtils.writeFile("~/out.txt",
                    Arrays.asList("Hello", " ", "world"),
                    Charset.defaultCharset(),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
     */
    public static void writeFile(String path, Iterable<String> lines, Charset cs, OpenOption... options)
            throws IOException
    {
        Files.write(Paths.get(path), lines, cs, options);
    }
}
