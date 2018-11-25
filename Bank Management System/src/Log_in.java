import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Log_in implements ActionListener{
	
	private Customer dataTemp;
	
	public JFrame frame;
	
	//Setting variables
	private JLabel blank;
	private JLabel blank2;
	private JLabel emailL;
	private JLabel passL;
	
	private JPasswordField pass;
	private JTextField email;
	
	private JButton logIn;
	
	private JMenuBar menuBar;
	private JMenu option;
	private JMenuItem cancel;

	
	public Log_in(){
		
		frame = new JFrame();
		
		//Setting Labels
		blank = new JLabel("");
		blank2 = new JLabel("");
		emailL = new JLabel(" 	Customer Email-ID");
		passL = new JLabel(" 	Password");

		//Setting input fields
		pass = new JPasswordField();
		email = new JTextField();
		
		//Setting buttons
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
		
		//Setting layout of the Frame
		GridLayout g = new GridLayout(4, 2);
		frame.setLayout(g);
		
		//Setting Elements to the Frame
		frame.add(blank2);
		frame.add(emailL);
		frame.add(email);
		frame.add(passL);
		frame.add(pass);
		frame.add(blank);
		frame.add(logIn);
		
		//Customizing the Frame
		frame.setSize(400, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocation(480, 220);
		frame.setTitle("Bank Management System");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == logIn){
			
			String keyId = email.getText();
			String keyPass = new String( pass.getPassword() );
			
			Customer [] data = new Customer[500];
			
			try{
				File f = new File("data.txt");
				Scanner x = new Scanner(f);
				int index = 0;
				
				while(x.hasNextLine()){
					
					String fn = x.nextLine();
					String ln = x.nextLine();
					String add = x.nextLine();
					String db = x.nextLine();
					String tele = x.nextLine();
					String mob = x.nextLine();
					String gen = x.nextLine();
					String accT = x.nextLine();
					String passw = x.nextLine();
					String bala = x.nextLine();
					int bal = Integer.parseInt(bala);
					
					Customer temp = new Customer(fn,ln,add,db,tele,mob,gen,accT,passw);
					temp.setBalance(bal);
					data[index] = temp;
					
					index++;
				}
				
				for(int i=0; i<data.length; i++){
					if( data[i] != null && data[i].getEmailId().equals(keyId) ){
						if( data[i].getPassword().equals(keyPass) ){
							dataTemp = data[i];
							new Customer_Window(dataTemp);
							frame.setVisible(false);
							break;
						}
						else{
							email.setText("");
							pass.setText("");
						}
					}
					else{
						email.setText("");
						pass.setText("");
					}
				}
	
			}catch(Exception e3){
				System.out.println(e3.getMessage());
			}
		}
		else if(e.getSource() == cancel){
			new Main_menu();
			frame.setVisible(false);
		}
	}
	
}
