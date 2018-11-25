import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Staff_Window implements ActionListener{
	//Initializing Variables
	private JFrame frame;
	
	private JLabel employeeName;
	
	private JButton checkAllAccounts;
	private JButton accountCheck;
	private JButton deleteAccount;
	
	private JMenuBar menuBar;
	private JMenu option;
	private JMenuItem logOut;
	
	//Employee object
	Employee e = new Employee();
	
	public Staff_Window(int i){
		//Setting Values of Variables
		frame = new JFrame( );
		employeeName = new JLabel("  Hello, " + e.getEmployee(i) );
		checkAllAccounts = new JButton("Check All Accounts");
		checkAllAccounts.addActionListener(this);
		accountCheck = new JButton("Check Specific Account");
		accountCheck.addActionListener(this);
		deleteAccount = new JButton("Close An Account");
		deleteAccount.addActionListener(this);
		
		//Setting Menu Bar
		menuBar = new JMenuBar();
		option = new JMenu("Option");
		logOut = new JMenuItem("Log Out");
		logOut.addActionListener(this);
		
		option.add(logOut);
		menuBar.add(option);
		frame.add(menuBar);
		
		//Setting Grid Layout
		GridLayout  g = new GridLayout(5,1);
		frame.setLayout(g);
		
		//Adding Components
		frame.add(employeeName);
		frame.add(checkAllAccounts);
		frame.add(accountCheck);
		frame.add(deleteAccount);
		
		
		
		//Customize Frame
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(480, 220);
		frame.setVisible(true);
		frame.setTitle("Bank Management System");
	}
	/*
	public static void main(String args[]){
		new Staff_Window();
	}*/
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == logOut){
			new Main_menu();
			frame.setVisible(false);
		}
		else if(e.getSource() == checkAllAccounts){
			
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
				
				System.out.println("* * * * * Customer Informations * * * * * *");
				System.out.println("Name - Email ID - Address - Date of Birth - Telephone - Mobile - Gender - Account Type - Balance");
				System.out.println("___________________________________________________________________________________________________________");
				
				for(int i=0; i<index;i++){
					System.out.print(data[i].getName() + "\t" + data[i].getEmailId() + "\t" +data[i].getAddress() + "\t" +data[i].getDob() + "\t" + data[i].getTelephone() + "\t" + data[i].getMobile() + "\t" + data[i].getGender() + "\t" +data[i].getAccountType() + "\t" + /*data[i].getPassword() +*/ "\tTK. " + data[i].getBalance() + "\n" );
				}
				
				System.out.println("-----------------------------------------------------------------------");
				System.out.println("Total Accouts = " + index );
				System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * *");
				
				JOptionPane.showMessageDialog(null, "Customer informations are printed in the console box!");
			}catch(Exception e1){
				System.out.println(e1.getMessage());
			}
		}
		else if(e.getSource() == accountCheck){
			
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
				
				String inputkey = JOptionPane.showInputDialog("Enter Email ID or Name of the Customer");
				inputkey = inputkey.toLowerCase();
				
				System.out.println("* * * * * Specific Customer Informations * * * * * *");
				System.out.println("Name - Email ID - Address - Date of Birth - Telephone - Mobile - Gender - Account Type - Balance");
				System.out.println("___________________________________________________________________________________________________________");
				
				for(int i=0; i<index;i++){
					if(data[i] != null && data[i].getEmailId().equals(inputkey) || data[i].getName().toLowerCase().equals(inputkey) ){
						System.out.print(data[i].getName() + "\t" + data[i].getEmailId() + "\t" +data[i].getAddress() + "\t" +data[i].getDob() + "\t" + data[i].getTelephone() + "\t" + data[i].getMobile() + "\t" + data[i].getGender() + "\t" +data[i].getAccountType() + "\t" + /*data[i].getPassword() +*/ "\tTK. " + data[i].getBalance() + "\n" );
					}
				}
				
				JOptionPane.showMessageDialog(null, "Customer informations are printed in the console box!");
				
			}catch(Exception e5){
				System.out.println(e5.getMessage());
			}
		}
		else if(e.getSource() == deleteAccount){
			
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
				
				String inputkey = JOptionPane.showInputDialog("Enter Email ID of the Customer");
				
				FileWriter dfw = new FileWriter("data.txt", false);
				
				for(int i=0; i< index; i++){
					
					if( data[i].getEmailId().equals(inputkey) ) {
					
					}
					else{
						dfw.write( data[i].getName() + "\n" );
						dfw.write( data[i].getEmailId() + "\n" );
						dfw.write( data[i].getAddress() + "\n" );
						dfw.write( data[i].getDob() + "\n" );
						dfw.write( data[i].getTelephone() + "\n" );
						dfw.write( data[i].getMobile() + "\n" );
						dfw.write( data[i].getGender() + "\n" );
						dfw.write( data[i].getAccountType() + "\n" );
						dfw.write( data[i].getPassword() + "\n" );
						dfw.write( data[i].getBalance() + "\n" );
					}
					
				}
				
				dfw.close();
				
			}catch(Exception e6){
				System.out.println(e6.getMessage());
			}
			
			JOptionPane.showMessageDialog(null, "The specified account has been closed.");
		}
	}
}