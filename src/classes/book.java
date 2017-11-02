package classes;

public class book {
    private String book_id;
    private String title;
    private String author_last_name;
    private String author_first_name;
    private int rating;


    public book(String book_id, String title,
                String author_last_name,
                String author_first_name,
                int rating) {
        this.book_id = book_id;
        this.title = title;
        this.author_last_name = author_last_name;
        this.author_first_name = author_first_name;
        this.rating = rating;
    }

}