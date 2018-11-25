
public class Customer {
	
	//Initializing variables
	private String password;
	private String name;
	private String emailId;
	private String address;
	private String dob;
	private String telephone;
	private String mobile;
	private String gender;
	private String accountType;
	private int balance;
	
	private static int count = 0;

	public Customer( String name, String emailId, String address, String dob, String telephone,
			String mobile, String gender, String accountType, String password) {

		this.name = name;
		this.emailId = emailId;
		this.address = address;
		this.dob = dob;
		this.telephone = telephone;
		this.mobile = mobile;
		this.gender = gender;
		this.accountType = accountType;
		this.password = password;
		count++;
	}

	//Initializing setters and getters
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getAddress() {
		return address;
	}

	public String getDob() {
		return dob;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public String getGender() {
		return gender;
	}

	public String getAccountType() {
		return accountType;
	}

	public int getBalance() {
		return balance;
	}

	public static int getCount() {
		return count;
	}
	
	
}
