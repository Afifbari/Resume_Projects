import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Customer_Window implements ActionListener{
	
		//Initializing Variables
		private JFrame frame;
		
		private JLabel customerName;
		
		private JButton accountInfo;
		private JButton balanceCheck;
		private JButton withdraw;
		private JButton deposit;
		
		private JMenuBar menuBar;
		private JMenu option;
		
		private JMenuItem logOut;
		
		Customer outsideObject;
		
		public Customer_Window(Customer o){
			
			//Setting Values of Variables
			frame = new JFrame( );
			outsideObject = o;
			customerName = new JLabel("  Hello, "  + o.getName() );
			accountInfo = new JButton("Account Information");
			accountInfo.addActionListener(this);
			balanceCheck = new JButton("Check Balance");
			balanceCheck.addActionListener(this);
			withdraw = new JButton("Withdraw Money");
			withdraw.addActionListener(this);
			deposit = new JButton("Deposit Money");
			deposit.addActionListener(this);
			
			//Setting Menu Bar
			menuBar = new JMenuBar();
			option = new JMenu("Option");
			logOut = new JMenuItem("Log Out");
			logOut.addActionListener(this);
			
			option.add(logOut);
			menuBar.add(option);
			frame.add(menuBar);
			
			//Setting Grid Layout
			GridLayout  g = new GridLayout(7,1);
			frame.setLayout(g);
			
			//Adding Components
			frame.add(customerName);
			frame.add(accountInfo);
			frame.add(balanceCheck);
			frame.add(withdraw);
			frame.add(deposit);
			
			//Customize Frame
			frame.setSize(400,250);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocation(480, 200);
			frame.setVisible(true);
			frame.setTitle("Bank Management System");
		}

		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == logOut){
				new Main_menu();
				frame.setVisible(false);
			}
			else if(e.getSource() == accountInfo){
				JOptionPane.showMessageDialog(null, "Name: " + outsideObject.getName() +
													"\nEmail ID: " + outsideObject.getEmailId() +
													"\nAddress: " + outsideObject.getAddress() +
													"\nDate of Birth: " + outsideObject.getDob() + 
													"\nTelephone: " + outsideObject.getTelephone() + 
													"\nMobile: " + outsideObject.getMobile() +
													"\nGender: " + outsideObject.getGender() +
													"\nAccount Type: " + outsideObject.getAccountType() +
													"\nPassword: " + outsideObject.getPassword() );
			}
			else if(e.getSource() == balanceCheck){
				JOptionPane.showMessageDialog(null, "Balance: Tk. " + outsideObject.getBalance() );
			}
			else if(e.getSource() == deposit){
				String sDepositAmount = JOptionPane.showInputDialog("Current Balance: TK." + outsideObject.getBalance() + "\nDeposit :\nN.B. Decimal deposit values will not be accepted.");
				int depositAmount = Integer.parseInt(sDepositAmount);
			
				if(depositAmount<0){
					JOptionPane.showMessageDialog(null, "Amount must be more than zero.");
				}
				else {
					
					//Re-writing the File
					Customer [] dataD = new Customer[500];
					
					int outsideIndex = 0;
					
					//Try-catch function for assembling a temporary customer array having all the customers account
					//and the modified balance of the specified account
					//And then the whole array is written in the same file with the necessary changes
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
							
							if(fn.equals( outsideObject.getName() ) ){
								Customer temp = new Customer(fn,ln,add,db,tele,mob,gen,accT,passw);
								temp.setBalance(bal+depositAmount);
								dataD[index] = temp;
								
								index++;
							}
							else{
								Customer temp = new Customer(fn,ln,add,db,tele,mob,gen,accT,passw);
								temp.setBalance(bal);
								dataD[index] = temp;
								
								index++;
							}
						}
						
						outsideIndex = index;
	
						FileWriter dfw = new FileWriter("data.txt", false);
						
						for(int i=0; i< outsideIndex; i++){
							
							dfw.write( dataD[i].getName() + "\n" );
							dfw.write( dataD[i].getEmailId() + "\n" );
							dfw.write( dataD[i].getAddress() + "\n" );
							dfw.write( dataD[i].getDob() + "\n" );
							dfw.write( dataD[i].getTelephone() + "\n" );
							dfw.write( dataD[i].getMobile() + "\n" );
							dfw.write( dataD[i].getGender() + "\n" );
							dfw.write( dataD[i].getAccountType() + "\n" );
							dfw.write( dataD[i].getPassword() + "\n" );
							dfw.write( dataD[i].getBalance() + "\n" );
							
						}
						
						dfw.close();
						
						JOptionPane.showMessageDialog(null, "Log in again to check new balance.");
						
					}catch(Exception e3){
						System.out.println(e3.getMessage());
					}
					
					frame.setVisible(false);
					new Log_in();
				}
			}
			else if(e.getSource() == withdraw){
				String sWithdrawAmount = JOptionPane.showInputDialog("Current Balance: TK." + outsideObject.getBalance() + "\nWithdraw:\nN.B. Decimal withdraw values will not be accepted.");
				int withdrawAmount = Integer.parseInt(sWithdrawAmount);
			
				int currentBalance = outsideObject.getBalance();
				int balanceAfterWithdraw = currentBalance - withdrawAmount;
				
				if(withdrawAmount<0){
					JOptionPane.showMessageDialog(null, "Amount must be more than zero.");
				}
				else {
					
					if(balanceAfterWithdraw<0){
						JOptionPane.showMessageDialog(null, "You don't have sufficiant balance.");
					}
					else {
						//Re-writing the File
						Customer [] dataD = new Customer[500];
						
						int outsideIndex = 0;
						
						//Try-catch function for assembling a temporary customer array having all the customers account
						//and the modified balance of the specified account
						//And then the whole array is written in the same file with the necessary changes
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
								
								if(fn.equals( outsideObject.getName() ) ){
									Customer temp = new Customer(fn,ln,add,db,tele,mob,gen,accT,passw);
									temp.setBalance(bal-withdrawAmount);
									dataD[index] = temp;
									
									index++;
								}
								else{
									Customer temp = new Customer(fn,ln,add,db,tele,mob,gen,accT,passw);
									temp.setBalance(bal);
									dataD[index] = temp;
									
									index++;
								}
							}
							
							outsideIndex = index;
		
							FileWriter dfw = new FileWriter("data.txt", false);
							
							for(int i=0; i< outsideIndex; i++){
								
								dfw.write( dataD[i].getName() + "\n" );
								dfw.write( dataD[i].getEmailId() + "\n" );
								dfw.write( dataD[i].getAddress() + "\n" );
								dfw.write( dataD[i].getDob() + "\n" );
								dfw.write( dataD[i].getTelephone() + "\n" );
								dfw.write( dataD[i].getMobile() + "\n" );
								dfw.write( dataD[i].getGender() + "\n" );
								dfw.write( dataD[i].getAccountType() + "\n" );
								dfw.write( dataD[i].getPassword() + "\n" );
								dfw.write( dataD[i].getBalance() + "\n" );
								
							}
							
							dfw.close();
							
							JOptionPane.showMessageDialog(null, "Log in again to check new balance.");
							
						}catch(Exception e3){
							System.out.println(e3.getMessage());
						}
					
						frame.setVisible(false);
						new Log_in();
					}
				}
			}
		}
}
