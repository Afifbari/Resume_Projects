import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;


public class Main_menu implements ActionListener{
	
	//Initializing variables
	private JFrame frame;
	
	private JLabel welcome;
	private JLabel blank;
	
	private JButton login;
	private JButton openAccount;
	
	private JMenuBar menuBar;
	private JMenu option;
	private JMenuItem staffLogIn;
	
	public Main_menu(){
		//Setting values for the Variables
		frame = new JFrame();
		
		welcome = new JLabel("                                            Welcome To Bank NSU");
		blank = new JLabel("");
		
		login = new JButton("Log In");
		openAccount = new JButton("Open New Account");
		
		//Adding Menu Bar to the Frame
		menuBar = new JMenuBar();
		option = new JMenu("Option");
		staffLogIn = new JMenuItem("Staff Login");
		staffLogIn.addActionListener(this);
		option.add(staffLogIn);
		
		menuBar.add(option);
		frame.setJMenuBar(menuBar);
		
		//Set Layout
		GridLayout g = new GridLayout(4,1);
		frame.setLayout(g);
		
		//Adding components in the frame
		frame.add(welcome);
		frame.add(login);
		login.addActionListener(this);
		frame.add(openAccount);
		openAccount.addActionListener(this);
		
		//Customizing the frame
		frame.setSize(400,250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Bank Management System");
		frame.setLocation(480, 200);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == staffLogIn){
			new Staff_Log_in();
			frame.setVisible(false);
		}
		else if(e.getSource() == openAccount){
			new New_Account_Window();
			frame.setVisible(false);
		}
		else if(e.getSource() == login){
			new Log_in();
			frame.setVisible(false);
		}
	}
	
	public static void main(String args[]){
		new Main_menu();
	}
}
