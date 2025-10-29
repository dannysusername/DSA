package Projects.Objects;

import java.util.Scanner;

public class BaseDocument extends Document {

    public BaseDocument(int id, String title, String description) {
        super(id, title, description);
        //TODO Auto-generated constructor stub
    }

    @Override
    void edit(Scanner in) {
        
    }

    @Override
    public void print() {
        System.out.print("Title: {" + this.getTitle() + "} Date: " + this.getDate());
        
    }
    
}
