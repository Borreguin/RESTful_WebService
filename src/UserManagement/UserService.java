package UserManagement;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;
import static classes.Conf_global.FAILURE_RESULT;
import static classes.Conf_global.SUCCESS_RESULT;


@Path("/UserService")
public class UserService {
    UserDao userDao = new UserDao();

    // Gets all users:
    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getUsers(){
        return userDao.getAllUsers();
    }

    // Gets user by ID
    @GET
    @Path("/users/{userid}")
    @Produces(MediaType.APPLICATION_XML)
    public User getUser(@PathParam("userid") int userid){
        return userDao.getUser(userid);
    }

    // creating a new user
    @POST
    @Path("/users")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String createUser(@FormParam("id") int id,
                             @FormParam("name") String name,
                             @FormParam("profession") String profession,
                             @Context HttpServletResponse serveltReponse)
    throws IOException{
        User user = new User( id, name, profession);
        int result = userDao.addUser(user);
        if(result == 1){
            return SUCCESS_RESULT;
        }
        return FAILURE_RESULT;
    }

    // Update an user:
    @PUT
    @Path("/users")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updateUser(@FormParam("id") int id,
        @FormParam("name") String name,
        @FormParam("profession") String profession,
        @Context HttpServletResponse servletResponse)
            throws IOException{

        User user = new User(id, name, profession);
        int result = userDao.updateUser(user);
        if (result == 1)
            return SUCCESS_RESULT;

        return FAILURE_RESULT;
    }

    // Delete an user
    @DELETE
    @Path("/users/{userid}")
    @Produces(MediaType.APPLICATION_XML)
    public String deleteUser(@PathParam("userid") int userid){
        int result = userDao.deleteUser(userid);
        if(result == 1)
            return SUCCESS_RESULT;
        return FAILURE_RESULT;
    }

    // Options:
    @OPTIONS
    @Path("/users")
    @Produces(MediaType.APPLICATION_XML)
    public String getSupportedOperations(){

        return "<operations>GET, PUT, POST, DELETE</operations>";
    }


}
