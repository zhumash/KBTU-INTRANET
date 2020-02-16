import java.io.Serializable;
import java.util.Date; 
public  class User extends Person implements Serializable {
	private String id;
    private String login; 
    private String password = defaultPassword;
    private String email = "N/A";
    private String phone = "N/A";
    private int serialID = 1; 
    public static String defaultPassword = "Kbtu2019";
    User() {
    	
    }
    public User(String lastName, String firstName, String login) {
        super(lastName, firstName);
        this.login = login;
        this.id = genUniqueID();
        
    }
    private String genUniqueID() {
        String res = "";
        for(int i = 0; i < 5 - serialID/10; ++i) {
        	res += "0";
        	
        }
        res += (serialID/10 + '0');
        serialID ++;
        return res;
        // 5 - sid/10 
    }
    public String  getID() {
    	return id;
    }
    public String getLogin() { return login; }

    public String getPassword() { return password; }
    public void  setLogin(String login) {
    	this.login = login;
    }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    
    public String toString() {
        String emailInfo = "Email: " + email + '\n';
        String phoneInfo = "Phone number: " + phone + '\n';
        String loginInfo = "Intranet login: " + login + '\n';
        String idInfo = "ID: " + id + "\n";
        return super.toString() + emailInfo + phoneInfo + loginInfo + idInfo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof User)) return false;
        User u = (User) obj;
        return u.id.equals(id);
    }

    @Override
    public int hashCode() {
    	return login.hashCode();
    }
}