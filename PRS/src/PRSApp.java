// import java.util.Scanner;

public class PRSApp {
	static UserDB userDB = null;

	public static void main(String[] args)  {
		userDB = new UserDB(); // userDB is defined in this class, UserDB is defined in class UserDB
		System.out.println("Add / Maintain Users");

		boolean successfulLogin = false;
		successfulLogin = userLogIn();
		if (successfulLogin != false) {
			//		Scanner sc = new Scanner(System.in);
			// sc.close();
			String choice = "";
			while (!choice.equalsIgnoreCase("6")) {
				displayMenu();
				choice = Console.getString("Option: ");
				if (choice.equalsIgnoreCase("1")) {
					// display all users
					for (User u:userDB.getUsers()) {
						System.out.println(u.toString());
					}
				}
				else if (choice.equalsIgnoreCase("2")) {
					// prompt for user name
					// display user information
					displayUserInfo();
				}
				else if (choice.equalsIgnoreCase("3")) {
					// prompt and add new user
					addUserToDB();
				}
				else if (choice.equalsIgnoreCase("4")) {
					// delete user
					deleteUserFromDB();
				}
				else if (choice.equalsIgnoreCase("5")) {
					// display user information
					// allow to be changed
					// prompt to update
					// update or go back to menu
				}


			}
		}

		System.out.println("Bye Bye");

	}
	
	public static void displayMenu() {
		System.out.println("Menu");
		System.out.println("1 - View All Users");
		System.out.println("2 - View User");
		System.out.println("3 - Add");
		System.out.println("4 - Delete");
		System.out.println("5 - Update");
		System.out.println("6 - Exit");
		return;
	}
	
	public static void displayUserInfo() {
		String userName = Console.getString("Enter User name: ");
		System.out.println("");
		User u = userDB.getUserByName(userName);
		
		System.out.println("User name:     " + u.getUserName());
		System.out.println("User Password: " + u.getPassWord());
		System.out.println("User Name:     " + u.getFirstName() + " " + u.getLastName());
		System.out.println("Phone:         " + u.getPhone());
		System.out.println("Email Address: " + u.getEmail());
		System.out.println("Reviewer:      " + u.isReviewer());
		System.out.println("Admin:         " + u.isAdmin());
		System.out.println("Active:        " + u.isActive());
		System.out.println("");
		Console.getString("Enter Exit and press [enter] to Continue");
	}

	public static void addUserToDB() {
		int id = UserDB.updateCount();
		System.out.println(" count " + id);
		String userName = Console.getString("User Name:");
		String passWord = Console.getString("Password: ");
		String firstName = Console.getString("First Name: ");
		String lastName = Console.getString("Last Name: ");
		String phone = Console.getString("Phone Number: ");
		String email = Console.getString("Email Address: ");
		Boolean reviewer = Console.getBoolean("Reviewer: ");
		Boolean admin = Console.getBoolean("Admin: ");
		boolean active = true;
		
		User u = new User(id, userName, passWord, firstName, lastName,
				phone, email, reviewer, admin, active);
		UserDB.addUser(u);
		System.out.println("user should have been added");
	}
	
	public static void deleteUserFromDB() {
		String userToDelete = Console.getString("User to be deleted: ");
		System.out.println(" user entered " + userToDelete);
		User u = userDB.getUserByName(userToDelete);
		if (u != null ) {
			userDB.deleteUser(u);
			System.out.println("Delete user " + userToDelete);
		}
		else {
			System.out.println("Didn't find username " + userToDelete);
		}
		String hault = Console.getString("what message was displayed");
	}
	
	public static boolean userLogIn () {
		
		String userNameEntered = Console.getString("User Name: ");
		String passwordEntered = Console.getString("Password: ");
		
		boolean successfulLogin = false;
		for (User u:userDB.getUsers()) {
			if ((u.getUserName().equals(userNameEntered)) && (u.getPassWord().equals(passwordEntered))) {
				System.out.println("is this correct");
				successfulLogin = true;
			}
		}
		if (successfulLogin == true)
			System.out.println(" login was successful");
		else
			System.out.println(" login failed");
		return successfulLogin;
	}
}
