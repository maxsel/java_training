package by.epam.composite.experimental;

import by.epam.composite.util.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by maxsel on 16.12.15.
 */
public class Experiment {
    public final static Logger LOG = Logger.getLogger(Experiment.class);
    private static final String PARAGRAPH_OR_LISTING = "((^\\s\\s\\s\\s(?![^\\n]*//:)[^\\n]+\\n)|(^\\s*//:.*?//:~\\s*\\n))";
    private static final String PARAGRAPH = "(^\\s\\s\\s\\s(?![^\\n]*//:)[^\\n]+\\n)";
    private static final String LISTING = "(^\\s*//:.*?//:~\\s*\\n)";

    public static void main(String[] args) {
        String text;
        try {
            text = FileUtils.readFile("./resources/text.txt", Charset.defaultCharset());
            System.out.println(text);
            Matcher porl = Pattern.compile(PARAGRAPH_OR_LISTING, Pattern.DOTALL).matcher(text);
            Matcher paragraph = Pattern.compile(PARAGRAPH, Pattern.DOTALL).matcher("");
            Matcher listing = Pattern.compile(LISTING, Pattern.DOTALL).matcher("");
            while (porl.find()) {
                System.out.print("New group found: \"" + porl.group() + "\". ");
                String component = porl.group();
                paragraph.reset(component);
                listing.reset(component);
                if (paragraph.matches()) {
                    System.out.println(" => PARAGRAPH");
                } else if (listing.matches()) {
                    System.out.println(" => LISTING");
                }

                System.out.println("---------------------------------");
                text = text.substring(porl.end());
                System.out.println(text);
                porl.reset(text);
            }
        } catch (IOException e) {
            LOG.error(e);
        }
    }
}
