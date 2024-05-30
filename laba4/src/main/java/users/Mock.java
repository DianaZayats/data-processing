package users;
import java.util.ArrayList;
import java.util.List;

public class Mock {
private List <User1> userlist = new ArrayList<>();
public Mock () {
	this.userlist.add(new User1(0, "Diana", 19));
	this.userlist.add(new User1(1, "Denis", 11));
	this.userlist.add(new User1(2, "Oleg", 49));
}
public List<User1> getUserlist() {
	return userlist;
}
public void setUserlist(List<User1> userlist) {
	this.userlist = userlist;
}
}
