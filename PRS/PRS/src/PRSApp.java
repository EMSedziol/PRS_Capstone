import java.time.LocalDate;
import java.util.ArrayList;

// import java.util.Scanner;

public class PRSApp {
	static UserDB userDB = null;
	static User validatedUser = null;
	static ProductDB productDB = null;
	static PurchaseRequestDB pRequestDB = null;
	static PRLineItemDB prLineItemDB = null;
//	private static String productId;

	public static void main(String[] args) {
		userDB = new UserDB();
		productDB = new ProductDB();
		pRequestDB = new PurchaseRequestDB();
		prLineItemDB = new PRLineItemDB();
		
		System.out.println("Main");

		 boolean successfulLogin = false;
		 successfulLogin = userLogIn();
		
		if (successfulLogin != false) {
			System.out.println("Welcome " + validatedUser.getFirstName() + " " + validatedUser.getLastName());
			String choice = "";
			while (!choice.equalsIgnoreCase("3")) {
				displayMainMenu();
				choice = Console.getString("Option: ");
				if (choice.equalsIgnoreCase("1")) {
					// create PO
					enterPO();
				} else if (choice.equalsIgnoreCase("2")) {
					displayUserMenu();
					String choiceUser = "";
					while (!choiceUser.equalsIgnoreCase("6")) {
						displayUserMenu();
						System.out.println("into User menu");
						choiceUser = Console.getString("Option: ");
						if (choiceUser.equalsIgnoreCase("1")) {
							// display all users"
							getListOfUsers();
						} else if (choiceUser.equalsIgnoreCase("2")) {
							// prompt for user name
							// display user information
							displayUserInfo();
						} else if (choiceUser.equalsIgnoreCase("3")) {
							// prompt and add new user
							addUserToDB();
						} else if (choiceUser.equalsIgnoreCase("4")) {
							// delete user
							deleteUserFromDB();
						} else if (choiceUser.equalsIgnoreCase("5")) {
							// display user information
							// allow to be changed
							// prompt to update
							// update or go back to menu
						}

					} // 3
				} // po or user
			} // 1 PO or 2 User menu
		}
	} // successful login

	public static void displayMainMenu() {
		System.out.println("Main Menu");
		System.out.println("1 - Enter PO");
		System.out.println("2 - User Menu");
		System.out.println("3 - Exit");
		return;
	}

	public static void displayUserMenu() {
		System.out.println("User Menu");
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
		String userName = Console.getString("User Name: ");
		String passWord = Console.getString("Password: ");
		String firstName = Console.getString("First Name: ");
		String lastName = Console.getString("Last Name: ");
		String phone = Console.getString("Phone Number: ");
		String email = Console.getString("Email Address: ");
		Boolean reviewer = Console.getBoolean("Reviewer: ");
		Boolean admin = Console.getBoolean("Admin: ");
		boolean active = true;

		User u = new User(id, userName, passWord, firstName, lastName, phone, 
				email, reviewer, admin, active);
		UserDB.addUser(u);
		System.out.println("user should have been added");
	}

	public static void getListOfPO() {
		ArrayList<PurchaseRequest> pRequests = PurchaseRequestDB.getPurchaseRequests();
		if (pRequests!=null) {
			System.out.println("List of current PO's");
			System.out.println("Requested By\t Description \t PO Total\t");
			for (PurchaseRequest pr:pRequests) {
				System.out.println(pr.getUserId() + " \t \t" 
				+ pr.getDescription() + "\t \t"
				+ PurchaseRequestDB.getPriceFormatted(pr.getTotal()));
			};
		} 
	}
	
	public static void enterPO() {
		getListOfPO();
		int id = PurchaseRequestDB.updateCount();
		System.out.println("PO Id " + id);
		String description = Console.getString("Description: ");
		String justification = Console.getString("Justification");
		String dateNeeded = Console.getString("Date Needed (ex: yyyy-mm-dd) ");
		String deliveryMode = Console.getString("Delivered by ");
		String userName = validatedUser.getUserName();
		System.out.println("");
		System.out.println("username for PO "+userName);
	
		boolean enterLineItem = true;
		double totalPO = 0.0;
		while (enterLineItem) {
			String lineItem = Console.getString("1 - enter line item, 2 - exit");
			if (lineItem.equalsIgnoreCase("1")) {
				for (Product prd : ProductDB.products) {
					System.out.println(prd.toString());
				};
				int purchaseRequestId = id;
				String productId = Console.getString("Product Id: ");	
				int quantity = Console.getInt("Quantity: ");
				int POid = PRLineItemDB.updateCount();
				double cost = ProductDB.getCost(id);
				if (cost > 0.0) totalPO = totalPO + (quantity * cost);
				System.out.println();
				System.out.println("cost " + cost + " quantity " 
						+ quantity + " totalPO " 
						+ PurchaseRequestDB.getPriceFormatted(totalPO));
				System.out.println();
				PRLineItem orli = new PRLineItem(POid, purchaseRequestId,
						productId, quantity, true);
				PRLineItemDB.addPRLineItem(orli);		
			} else if (lineItem.equalsIgnoreCase("2")) {
				if (totalPO > 0.0) {
					PurchaseRequest p = new PurchaseRequest(id, 
							validatedUser.getUserName(),
							description, justification, dateNeeded, deliveryMode, 
							"new", totalPO, "2017-11-21", "", true);
					PurchaseRequestDB.addPurchaseRequest(p);
					System.out.println();
					System.out.println();
					enterLineItem = false;
				}
			}
				
		}

	}

	public static void getListOfPOLineItems(String purchaseRequestId) {
		ArrayList<PRLineItem> prLineItems = PRLineItemDB.getPRLineItems();
		if (prLineItems!=null) {
			System.out.println(" PO line item list");
			Product prod = null;
			for (PRLineItem poli:prLineItems) {
				String desc = prod.getCode();
				double price = prod.getPrice();
				System.out.println("Product Code " + poli.getProductId() 
					+ "Description " + desc 
					+ " Quantity " + poli.getQuantity()
						+ poli.getQuantity()
					+ " Line Total " + (poli.getQuantity() * price));
			};
		}
	}
	
	public static void deleteUserFromDB() {
		String userToDelete = Console.getString("User to be deleted: ");
		System.out.println(" user entered " + userToDelete);
		User u = userDB.getUserByName(userToDelete);
		if (u != null) {
			userDB.deleteUser(u);
			System.out.println("Delete user " + userToDelete);
		} else {
			System.out.println("Didn't find username " + userToDelete);
		}
	}

	public static void getListOfUsers() {
		ArrayList<User> users = UserDB.getUsers();
		if (users!=null) {
			System.out.println(" in UserDB getListOfUsers");
			for (User usr:users) {
				System.out.println(usr.toString());
			};
		}
	}
	 public static boolean userLogIn () {
	  
	  String userNameEntered = Console.getString("User Name: "); 
	  String passwordEntered = Console.getString("Password: ");
	  
	  boolean successfulLogin = false; 
	  User u = userDB.getLoginUser(userNameEntered, passwordEntered);
	  if (u != null) {
		  System.out.println(" login was successful"); 
		  successfulLogin = true;
		  validatedUser = u;
	  }
	  else
		  System.out.println(" login failed"); 
	 return successfulLogin;
	 }
}
