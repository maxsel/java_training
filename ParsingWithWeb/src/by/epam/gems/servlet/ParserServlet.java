package by.epam.gems.servlet;

import by.epam.gems.entity.Gem;
import by.epam.gems.helper.GemToString;
import by.epam.gems.parser.AbstractGemsBuilder;
import by.epam.gems.parser.GemBuilderFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet("/parser_action")
public class ParserServlet extends HttpServlet {
    private static GemBuilderFactory gemBuilderFactory = new GemBuilderFactory();
    private static Logger LOG = LogManager.getLogger(ParserServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String parser = request.getParameter("parser");
        String res;
        if (parser == null) {
            res = "no button has been selected";
        } else if (parser.equals("DOM")) {
            res = "DOM";
        } else if (parser.equals("SAX")) {
            res = "SAX";
        } else if (parser.equals("StAX")) {
            res = "StAX";
        } else {
            res = "someone has altered the HTML and sent a different value!";
        }
        res = res.toUpperCase();
        request.setAttribute("res", res);
        if (res.equals("DOM") || res.equals("SAX") || res.equals("STAX")) {
            AbstractGemsBuilder builder = gemBuilderFactory.createGemBuilder(res);
            String path = getClass().getClassLoader().getResource("data/gems.xml").getPath();
            // another way of getting gems.xml
            // ServletContext sc = config.getServletContext();
            // String webAppPath = sc.getRealPath("/");
            // -:> /home/maxsel/IdeaProjects/java_training/ParsingWithWeb/out/artifacts/ParsingWithWeb_war_exploded/
            builder.buildSetGems(path);
            Set<Gem> gems = builder.getGems();
            Set<String> stringGems =
                    gems
                            .stream()
                            .map(g -> GemToString.convert(g))
                            .collect(Collectors.toSet());
            request.setAttribute("gems", stringGems);
        }

        LOG.debug("goodbye");
        request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);
    }
}