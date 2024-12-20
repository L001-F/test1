package Model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.AddNewAccount;
import Controller.ChangePassword;
import Controller.ShowAllRents;
import Controller.ShowSpecUserRents;
import Controller.UpdateCar;
import Controller.ViewCars;

public class Gestionnaire extends User {
	
	private Operation[] operations = new Operation[] {
				new ViewCars(),
				new UpdateCar(),
				new AddNewAccount(4),
				new ShowAllRents(),
				new ShowSpecUserRents(),
				new ChangePassword()};
	
	private JButton[] btns = new JButton[] {
			new JButton("View Cars", 22),
			new JButton("Update Car", 22),
			new JButton("Add New Gestionnaire", 22),
			new JButton("Show Rents", 22),
			new JButton("Show User's Rents", 22),
			new JButton("Change Password", 22)
	};
	
	public Gestionnaire() {
		super();
	}

	@Override
	public void showList(Database database, JFrame f) {
		
		JFrame frame = new JFrame("Admin Panel");
		frame.setSize(400, btns.length*80);
		frame.setLocationRelativeTo(f);
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Welcome "+getFirstName(), 30);
		title.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
		frame.add(title, BorderLayout.NORTH);
		
		JPanel panel = new JPanel(new GridLayout(btns.length, 1, 15, 15));
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		for (int i=0;i<btns.length;i++) {
			final int j = i;
			JButton button = btns[i];
			panel.add(button);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					operations[j].operation(database, frame, Gestionnaire.this);
				}
			});
		}
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
}