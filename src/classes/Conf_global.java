package classes;
import java.nio.file.Path;
import java.nio.file.Paths;

// This class contains parameters, methods and variables that
// are common for several classes
public class Conf_global {

    // Notification Messages:
    public static final String SUCCESS_RESULT = "<result>success</result>";
    public static final String FAILURE_RESULT = "<result>failure</result>";
    private String pathProject;

    public Conf_global() {

        // Getting the root directory:
        String suffix = "WEB-INF";
        String path[] = Conf_global.class.getResource("Conf_global.class").toString().split(suffix);
        pathProject = path[0].replace("file:/", "") + suffix;

    }

    public String root(){
        return this.pathProject;
    }


}
