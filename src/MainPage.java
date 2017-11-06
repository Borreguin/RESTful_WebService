
import classes.Conf_global;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.*;



// This is the path for this page
@Path("default")

public class MainPage {

    // Global variables and settings:
    private Conf_global glb = new Conf_global();

    //the Java Method will process HTTP GET requests

    @GET
    // The Java method will produce content identified by
    // the MIME Media type "text/plain"
    @Produces({MediaType.TEXT_HTML})
    public InputStream getClichedMessage() throws FileNotFoundException {

        // Getting an html file
        String path = glb.root() + "/Resources/templates/default.htm";
        File f = new File(path);
        return new FileInputStream(f);
    }
}

/* connecting to Oracle DB
    // Return some cliched textual content
    StringBuilder toPrint = new StringBuilder();

    // Connecting to Oracle dataBase (example)
    // in $GLASS_FISH_DIRECTORY$\domains\domain1\lib\ext
    // is necessary to put the driver: ojdbc6 or superior
    oracle_handle db = new oracle_handle();
    List<Book> library = db.getBookByTittle("%a%");
        for(Book bk: library){
        toPrint.append("\n" + bk.getTitle());
    }
    // End of example.
        return "This is my first service: Hello World \n\n -- Books in Library DB:\n" + toPrint;
        */