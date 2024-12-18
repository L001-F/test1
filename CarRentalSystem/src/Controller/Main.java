package Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*; 
import Model.*; 

public class Main {

    private static Database database;

    public static void main(String[] args) {
        database = new Database();
        start();
    }

    public static void start() {
        
        JFrame frame = new JFrame("Login");
        frame.setSize(600, 330);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(220, 240, 255)); // Light blue
        frame.setLayout(new BorderLayout());

        
        Model.JLabel title = new Model.JLabel("Welcome to Car Rental System", 35);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        title.setForeground(new Color(30, 60, 90)); // Dark blue text
        frame.add(title, BorderLayout.NORTH);


        JPanel panel = new JPanel(new GridLayout(3, 2, 15, 15));
        panel.setBackground(new Color(240, 248, 255)); // Very light blue
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        
        panel.add(new Model.JLabel("Email:", 22));
        Model.JTextField email = new Model.JTextField(22);
        email.setBackground(Color.white);
        email.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200))); // Light gray border
        panel.add(email);

        
        panel.add(new Model.JLabel("Password:", 22));
        Model.JPasswordField password = new Model.JPasswordField(22);
        password.setBackground(Color.white);
        password.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200))); // Light gray border
        panel.add(password);

        
        Model.JButton createAcc = new Model.JButton("Create New Account", 22);
        createAcc.setBackground(new Color(30, 144, 255)); // Blue button
        createAcc.setForeground(Color.white); // White text
        createAcc.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding for button
        createAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddNewAccount(0).operation(database, frame, null);
                frame.dispose();
            }
        });
        panel.add(createAcc);


        ArrayList<User> users = new ArrayList<>();
        try {
            String select = "SELECT * FROM `users`;";
            ResultSet rs = database.getStatement().executeQuery(select);
            while (rs.next()) {
                User user;
                int ID = rs.getInt("ID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String em = rs.getString("Email");
                String phoneNumber = rs.getString("PhoneNumber");
                String pass = rs.getString("Password");
                int type = rs.getInt("Type");

                if (type == 0) {
                    user = new Client();
                } else {
                    user = new Admin();
                }
                user.setID(ID);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(em);
                user.setPhoneNumber(phoneNumber);
                user.setPassword(pass);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        Model.JButton login = new Model.JButton("Login", 22);
        login.setBackground(new Color(30, 144, 255)); 
        login.setForeground(Color.white); 
        login.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); 
        login.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent e) {
                if (email.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, "Email cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (password.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, "Password cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean loggedIn = false;
                for (User u : users) {
                    if (u.getEmail().equals(email.getText()) && u.getPassword().equals(password.getText())) {
                        loggedIn = true;
                        u.showList(database, frame);
                        frame.dispose();
                    }
                }
                if (!loggedIn) {
                    JOptionPane.showMessageDialog(frame, "Email or password doesn't match", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(login);

       
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}


