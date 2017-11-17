import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class UserDB {
	static // hard code data for testing
	
	ArrayList<User> users = null;
	static int countDB = 0; // temporary MySQL will increment id automatically
	
	public UserDB()  {
		users = new ArrayList<>();
		users.add(new User(0, "ems", "ems123", "Emilie", "Sedziol", "513-481-7135",
			"ems5180@fuse.net", true, true, true));
		updateCount();
		users.add(new User(1, "esedziol", "e213", "E", "Seziol", "513-222-1234",
				"esedziol@something.com", false, false, true));
		updateCount();
		users.add(new User(2,"mylesad", "myles", "Myles", "Mysunshine", "333-321-4321",
				"myles@sunshine.com", true, false, false));
		
		// The file name an path is hard coded, this can be changed in the future
		Path userPath = Paths.get("c:\\Users\\sedzi\\JavaUsers.txt");
		
		try {
			File userFile = userPath.toFile();
			BufferedReader in = new BufferedReader(
					new FileReader(userFile));
			String line;
			while ((line = in.readLine()) != null) {
				parseLineAddToUserDB(line);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Bye Bye");

	}
	
	private static void parseLineAddToUserDB(String line){
		// takes a tab delimited file, parses the data and add's it into the ListArray
		int id = updateCount();
		
		String[] fields = line.split("\t");
		String userName = fields[0];
		String passWord = fields[1];
		String firstName = fields[2];
		String lastName = fields[3];
		String phone = fields[4]; // '/n' is at the beginning of the string
		String email = fields[5];
		Boolean reviewer = Boolean.valueOf(fields[6]);
		Boolean admin = Boolean.valueOf(fields[7]);
		boolean active = true;
		
		User u = new User(id, userName, passWord, firstName, lastName,
				phone, email, reviewer, admin, active);
		addUser(u);
		System.out.println("user " + userName + " added from a .txt file");
	}
	
	public static int updateCount() {
		countDB++;
		return countDB;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public  void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public static void addUser(User user) {
		users.add(user);
	}
	
	public void deleteUser(User user) {
		users.remove(user);
	}
	
	public User getUserByName(String userName) {
		System.out.println("userName " + userName);
		User u = null;
		for (User usr:users) {
			System.out.println(" usr.getUserName " + usr.getUserName());
			if (usr.getUserName().equalsIgnoreCase(userName)) {
				System.out.println("name found");
				u = usr;
			}
		}
		return u;
	}
	
}
