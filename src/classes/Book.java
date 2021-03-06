package classes;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
    private String book_id;
    private String title;
    private String author_last_name;
    private String author_first_name;
    private int rating;


    public Book(String book_id, String title,
                String author_last_name,
                String author_first_name,
                int rating) {
        this.book_id = book_id;
        this.title = title;
        this.author_last_name = author_last_name;
        this.author_first_name = author_first_name;
        this.rating = rating;
    }

    public String getAuthor_last_name() {
        return author_last_name;
    }

    public String getTitle() {
        return title;
    }
}