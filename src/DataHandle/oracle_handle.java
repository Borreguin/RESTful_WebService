package DataHandle;

import classes.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class oracle_handle {
    private static Connection conn;

    // Connecting to Oracle dataBase (example)
    // in $GLASS_FISH_DIRECTORY$\domains\domain1\lib\ext
    // is necessary to put the driver: ojdbc6 or superior

    public List<Book> getBookByTittle(String title) throws SQLException{
        // Making the SQL query
        List<Book> books = new ArrayList<>();
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            //Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "chris","chrisOracle");
            PreparedStatement ps;
            ps = conn.prepareCall("SELECT * FROM BOOKS WHERE \"TITLE\" LIKE :title");

            ps.setString((Integer) 1, title);
            ps.execute();
            // Getting the result
            ResultSet rs = ps.getResultSet();

            while (rs.next()){

                books.add(new Book(rs.getString(1), //id
                        rs.getString(2),  // title
                        rs.getString(3),  // author last name
                        rs.getString(4),  // author first name
                        rs.getInt(5) ));  // rating
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return books;
    }

}