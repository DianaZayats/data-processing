package users;
import java.util.ArrayList;
import java.util.List;

public class Mock {
private List <User> userlist = new ArrayList<>();
public Mock () {
	this.userlist.add(new User(0, "Diana", 19));
	this.userlist.add(new User(1, "Denis", 11));
	this.userlist.add(new User(2, "Oleg", 49));
}
public List<User> getUserlist() {
	return userlist;
}
public void setUserlist(List<User> userlist) {
	this.userlist = userlist;
}
}
