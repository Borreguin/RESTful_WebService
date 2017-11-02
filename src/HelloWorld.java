import DataHandle.oracle_handle;
import classes.book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.sql.SQLException;
import java.util.List;

// This the path for this page
@Path("helloWorld")

public class HelloWorld {
    //the Java Method will process HTTP GET requests

    @GET
    // The Java method will produce content identified by
    // the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() throws SQLException {
        // Return some cliched textual content

        oracle_handle db = new oracle_handle();
        List<book> library = db.getBookByTittle("%a%");

        return "This is my first service: Hello World";
    }
}
