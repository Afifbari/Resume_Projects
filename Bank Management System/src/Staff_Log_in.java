import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Staff_Log_in implements ActionListener{

	//Initializing variables
	private JFrame frame;
	
	private JLabel blank;
	private JLabel blank2;
	private JLabel idL;
	private JLabel passL;
	
	private JPasswordField pass;
	private JTextField id;
	
	private JButton logIn;
	
	//Initializing Menu bar variables
	private JMenuBar menuBar;
	private JMenu option;
	private JMenuItem cancel;
	
	//Employee object
	Employee p = new Employee();
	
	
	public Staff_Log_in(){
		
		//Initialize the components
		frame = new JFrame();
		
		blank2 = new JLabel("");
		blank = new JLabel("");
		idL = new JLabel(" 	Employee ID");
		passL = new JLabel(" 	Password");

		pass = new JPasswordField();
		id = new JTextField();
		
		logIn = new JButton("Log In");
		logIn.addActionListener(this);
		
		
		//Setting Menu Bar
		menuBar = new JMenuBar();
		option = new JMenu("Option");
		cancel = new JMenuItem("Cancel");
		cancel.addActionListener(this);
						
		option.add(cancel);
		menuBar.add(option);
		frame.add(menuBar);
		
		//Setting layout of the frame
		GridLayout g = new GridLayout(4, 2);
		frame.setLayout(g);
		
		//Adding components to the frame
		frame.add(blank2);
		frame.add(idL);
		frame.add(id);
		frame.add(passL);
		frame.add(pass);
		frame.add(blank);
		frame.add(logIn);
		
		//Customizing the Frame
		frame.setSize(400, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocation(480, 200);
		frame.setTitle("Bank Management System");
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logIn){
			String a  = id.getText(); // value of id
			String b = new String( pass.getPassword() ); // value of password
			
			int i;
			
			for(i=0; i<p.employee.length; i++){
				if(p.getEmployee(i).equals(a) && p.getEmployeePass(i).equals(b) ){
					new Staff_Window(i);
					frame.setVisible(false);
					break;
				}
				else{
					//JOptionPane.showMessageDialog(null, "Try again!");
					id.setText("");
					pass.setText("");
					//break;
				}
			}
			
			if(i==p.employee.length)
				JOptionPane.showMessageDialog(null, "Try again!");
			
		}
		else if(e.getSource() == cancel){
			new Main_menu();
			frame.setVisible(false);
		}
		
		
	}
	
}