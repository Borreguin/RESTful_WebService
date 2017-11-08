package BookManager;

import DataHandle.oracle_handle;
import classes.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/BookService")
public class BookService {

    /* connecting to Oracle DB (example)
    in $GLASS_FISH_DIRECTORY$\domains\domain1\lib\ext
    is necessary to put the driver: ojdbc6 or superior
     */

    private oracle_handle db = new oracle_handle();

    @GET
    @Path("/books")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() throws SQLException {
        return db.getBookByTittle("%%");
    }

}
