package Projects.Objects;
import java.time.LocalDate;
import java.util.Scanner;

public abstract class Document {

    protected int id;
    protected String title;
    protected String description;
    protected LocalDate date;

    public Document(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = LocalDate.now();

    }

    public abstract void edit(Scanner in);

    public int getId() {
        return id;        
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public abstract void print();


}