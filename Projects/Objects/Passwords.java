package Projects.Objects;

import java.time.LocalDate;
import java.util.Scanner;

public class Passwords extends Document{

    private String username;
    private String password;

    public Passwords(int id, String title, String description, String username, String password) {
        super(id, title, description);
        this.username = username;
        this.password = password;
        
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void edit(Scanner in) {
        print();
    }

    @Override
    public void print() {
        System.out.print("Title: {" + this.getTitle() + "} Username: " + this.getUsername() + " Date: " + this.getDate());

    }

    

    

   

    
}
