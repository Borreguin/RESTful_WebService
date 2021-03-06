
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
    // the MIME Media type "text/html"
    @Produces({MediaType.TEXT_HTML})
    public InputStream getClichedMessage() throws FileNotFoundException {

        // Getting an html file
        String path = glb.root() + "/Resources/templates/default.htm";
        File f = new File(path);
        return new FileInputStream(f);
    }
}

