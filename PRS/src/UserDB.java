import java.util.ArrayList;

public class UserDB {
	// hard code data for testing
	
	ArrayList<User> users = null;
	
	public UserDB() {
		users = new ArrayList<>();
		users.add(new User(0, "ems", "ems123", "Emilie", "Sedziol", "513-481-7135",
			"ems5180@fuse.net", true, true, true));
		users.add(new User(1, "esedziol", "e213", "E", "Seziol", "513-222-1234",
				"esedziol@something.com", false, false, true));
		users.add(new User(2,"mylesad", "myles", "Myles", "Mysunshine", "333-321-4321",
				"myles@sunshine.com", true, false, false));
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public  void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void deleteUser(User user) {
		users.remove(user);
	}
	
	public User getUserByName(String userName) {
		User u = null;
		for (User usr:users) {
			if (usr.getUserName().equalsIgnoreCase(userName)) {
				u = usr;
			}
		}
		return u;
	}
	
	public int getNextId() {
		int retval = users.size();
		return retval;
	}
	

}
