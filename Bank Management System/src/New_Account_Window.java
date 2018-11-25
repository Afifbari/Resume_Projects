import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class New_Account_Window implements ActionListener{
	
	//Setting Variables for the Frame
	private JFrame frame;
	private JLabel blank;
	private JLabel nameL;
	
	//private JLabel midNameL;
	private JLabel emailIdL;
	private JLabel addressL;
	private JLabel dobL;
	private JLabel telephoneL;
	private JLabel mobileL;
	private JLabel nationalityL;
	private JLabel genderL;
	private JLabel accountTypeL;
	private JLabel passL;
	
	private JTextField name;
	private JTextField emailId;
	private JTextField address;
	private JTextField telephone;
	private JTextField mobile;
	private JTextField nationality;
	private JTextField dob;
	private JComboBox gender;
	private JComboBox accountType;
	private JPasswordField pass;
	
	private JButton submit;
	private JButton clear;
	
	private JMenuBar menuBar;
	private JMenu option;
	private JMenuItem cancel;
	
	//private boolean unvarified;
	//private boolean varified;
	
	public New_Account_Window(){
		
		frame = new JFrame();
		
		//Setting labels
		blank =  new JLabel(" ");
		nameL = new JLabel("  Name");
		emailIdL = new JLabel("  Email ID");
		addressL = new JLabel("  Address");
		telephoneL = new JLabel("  Telephone");
		mobileL = new JLabel("  Mobile");
	    nationalityL = new JLabel("  Nationality");
	    dobL = new JLabel("  Date of Birth\n  (DD-MMM-YYYY)");
	    genderL = new JLabel("  Gender");
	    accountTypeL = new JLabel("  Account Type");
	    
	    passL =  new JLabel("  Set Password");
	    
	    //Setting input fields
	    name = new JTextField();
	    emailId = new JTextField();
	    address = new JTextField();
	    telephone = new JTextField();
	    mobile = new JTextField();
	    dob = new JTextField();
	    pass =  new JPasswordField();
	    String accountOptions[] = {"Savings", "Fixed", "Current"};
	    accountType = new JComboBox(accountOptions);
	    String genderOptions[] = {"Male", "Female"};
	    gender = new JComboBox(genderOptions);
	    
	    //Setting Buttons
	    submit = new JButton("Submit");
	    submit.addActionListener(this);
	    clear = new JButton("Clear");
	    clear.addActionListener(this);
	    
	    //Setting Menu Bar
		menuBar = new JMenuBar();
		option = new JMenu("Option");
		cancel = new JMenuItem("Cancel");
		cancel.addActionListener(this);
		
		option.add(cancel);
		menuBar.add(option);
		frame.add(menuBar);
	    
	    //Setting Layout of the Frame
	    GridLayout g = new GridLayout(11,2);
	    frame.setLayout(g);
	    
	    //Adding Elements to the Frame
	    frame.add(blank);
	    frame.add(nameL);
	    frame.add(name);
	    frame.add(emailIdL);
	    frame.add(emailId);
	    frame.add(addressL);
	    frame.add(address);
	    frame.add(dobL);
	    frame.add(dob);
	    frame.add(telephoneL);
	    frame.add(telephone);
	    frame.add(mobileL);
	    frame.add(mobile);
	    frame.add(genderL);
	    frame.add(gender);
	    frame.add(accountTypeL);
	    frame.add(accountType);
	    frame.add(passL);
	    frame.add(pass);
	    frame.add(submit);
	    frame.add(clear);
	    
	    //Customizing Frame
	    frame.setSize(400, 400);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    frame.setLocation(480, 130);
	    frame.setTitle("Bank Management System");
	    
	}
	
	/*public static void main(String args[]){
		new New_Account_Window();
	}*/
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == clear){
			name.setText("");
			emailId.setText("");
			address.setText("");
			dob.setText("");
			telephone.setText("");
			mobile.setText("");
			pass.setText("");
			gender.setSelectedIndex(0);
			accountType.setSelectedIndex(0);
		}
		else if(e.getSource() == cancel){
			new Main_menu();
			frame.setVisible(false);
		}
		else if(e.getSource() == submit){
			
			String inputEmail = emailId.getText();
			boolean notExist = true;
			
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
			} catch(Exception e5){
				System.out.println(e5.getMessage());
			}
			
			for(int i=0; i<data.length; i++){
				if( data[i] != null && data[i].getEmailId().equals(inputEmail) ){
						notExist = false;
						break;
				}
			}
			
			if(notExist){
				
				String fn = name.getText();
				String ema = emailId.getText();
				String add = address.getText();
				String db = dob.getText();
				String tele = telephone.getText();
				String mob = mobile.getText();
				String passw = new String( pass.getPassword() );
				String gen = gender.getSelectedItem().toString();
				String accT = accountType.getSelectedItem().toString();
				
				Customer customerObject = new Customer(fn,ema,add,db,tele,mob,gen,accT,passw);
				customerObject.setBalance(0);
				
				if(fn.equals("") || ema.equals("") || add.equals("") || db.equals("") || tele.equals("") || mob.equals("") || passw.equals("")|| gen.equals("")|| accT.equals("")){
					JOptionPane.showMessageDialog(null, "Fill up all entries!!");
				}
				else{
					try{ 
						
						FileWriter fw = new FileWriter("data.txt",true);
						
						//fw.write( Customer.getId() + " " );
						fw.write( customerObject.getName() + "\n" );
						fw.write( customerObject.getEmailId() + "\n" );
						fw.write( customerObject.getAddress() + "\n" );
						fw.write( customerObject.getDob() + "\n" );
						fw.write( customerObject.getTelephone() + "\n" );
						fw.write( customerObject.getMobile() + "\n" );
						fw.write( customerObject.getGender() + "\n" );
						fw.write( customerObject.getAccountType() + "\n" );
						fw.write( customerObject.getPassword() + "\n" );
						fw.write( customerObject.getBalance() + "\n" );
						
				
						fw.close();
						
						JOptionPane.showMessageDialog(null, "Your account is created!!");
						
						
						name.setText("");
						emailId.setText("");
						address.setText("");
						dob.setText("");
						telephone.setText("");
						mobile.setText("");
						pass.setText("");
						gender.setSelectedIndex(0);
						accountType.setSelectedIndex(0);
						
						frame.setVisible(false);
						new Main_menu();
						
						
					}catch(Exception e2){
						System.out.println(e2.getMessage());
					}
				}
				
			}
			else{
				JOptionPane.showMessageDialog(null, "This Email ID already has an account! \nTry with another Email ID.");
			
				name.setText("");
				emailId.setText("");
				address.setText("");
				dob.setText("");
				telephone.setText("");
				mobile.setText("");
				pass.setText("");
				gender.setSelectedIndex(0);
				accountType.setSelectedIndex(0);
			}
		}
	}
}
