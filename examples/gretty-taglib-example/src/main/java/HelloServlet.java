import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Set<String> libs = getServletContext().getResourcePaths("/WEB-INF/libs");
        if(libs.isEmpty()) {
            // Following output will be produced by Gretty
            resp.getOutputStream().print("<p>/WEB-INF/libs are empty</p>");
        } else {
            resp.getOutputStream().print("<p>");
            // Following output will be produced by maven-jetty-plugin:
            for (String lib : libs) {
                resp.getOutputStream().print(lib);
            }
            resp.getOutputStream().print("</p>");
        }
    }
}