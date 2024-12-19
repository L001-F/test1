package Controller;

import javax.swing.JFrame;
import Model.Database;
import Model.Operation;
import Model.User;

public class Quit implements Operation {

    @Override
    public void operation(Database database, JFrame f, User user) {

        System.out.println("Thanks for visiting us!");
        f.dispose(); // Correctly closes the JFrame
        
    }
}
