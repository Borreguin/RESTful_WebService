import UserManagement.User;
import UserManagement.UserDao;
import UserManagement.UserService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

// Defines the base URI (Uniform Resource Identifier) for all resources URIs
// URI = {URL, URN}
@ApplicationPath("/")
// The java class declares:
// - root resources and
// - provider classes

public class MyApplication extends Application {
    // the method returns a non-empty collection with classes, that must be included
    // in the published JAX-RS application
    // JAX-RS application = RESTful web Services application
    // it uses servlet classes that are automatically added.

    @Override
    public Set<Class<?>> getClasses(){
        HashSet h = new HashSet<Class<?>>();
        h.add(MainPage.class);
        h.add(User.class);
        h.add(UserDao.class);
        h.add(UserService.class);
        return h;
    }
}
