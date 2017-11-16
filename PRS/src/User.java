
public class User {
	private int id;
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private boolean reviewer;
	private boolean admin;
	private boolean active;
	
	public User() {
		userName = "";
		passWord = "";
	}
	
/*	public User(int id, String userName, String passWord, String firstName, String lastName, String phone, String email,
			boolean reviewer, boolean admin, boolean active) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.reviewer = reviewer;
		this.admin = admin;
		this.active = active;
	}*/
	
	public User(int id, String userName, String passWord, String firstName, String lastName,
			String phone, String email, boolean reviewer, boolean admin, boolean active) {
		setId(id);
		setUserName(userName);
		setPassWord(passWord);
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setEmail(email);
		setReviewer(reviewer);
		setAdmin(admin);
		setActive(active);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isReviewer() {
		return reviewer;
	}
	public void setReviewer(boolean reviewer) {
		this.reviewer = reviewer;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) { 
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id
				+ ", userName=" + userName
				+ ", password=" + passWord
				+ ", firstName=" + firstName
				+ ", lastName=" + lastName
				+ ", phone=" + phone
				+ ", email=" + email
				+ ", reviewer=" + reviewer
				+ ", admin=" + admin
				+ ", active=" + active + "]";
	}
	
}
