import java.io.*;
import java.util.*;
public class Menu {
	static  Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		Data.loginPassword = new HashMap<String,String> ();
		Data.students = new Vector <Student> ();
		Data.teachers = new Vector <Teacher> ();
		Data.managers = new Vector <Manager> ();
		Data.DSirlz(); 
		
		System.out.println("Enter your login: ");
		String login = sc.next();
		while(!Data.loginPassword.containsKey(login)) {
			System.out.println("invalid  login try again:");
			login = sc.next();
		}// invalid pas
		System.out.println("Enter your password: ");
		String passw = sc.next ();
		int cnt = 1;
		while(!Data.loginPassword.get(login).equals(passw)) {
			if(cnt % 3 == 0) {
				for(int i = 90; i >=  1; --i) {
					System.out.println(i/60 + " " + i%60);
					Thread.sleep(1000);
				}
			}
			System.out.println("invalid  password try again:");
			passw = sc.next ();
			cnt ++;
		}
		System.out.println("You are Welcome!");
		String type = "-";
		try {
			for(Student s : Data.students) {
				if(s.getLogin().equals(login)) {
					type = "Student"; 
					break;
				}
			}
		 }
		 catch (NullPointerException e) {
			 
		 }
		try {
			for(Manager s : Data.managers) {
				if(s.getLogin().equals(login)) {
					type = "Manager"; 
					break;
				}
			}
		 }
		 catch (NullPointerException e) {
			 
		 }
		
		try {
			for(Teacher s : Data.teachers) {
				if(s.getLogin().equals(login)) {
					type = "Teacher"; 
					break;
				}
			}
		 }
		 catch (NullPointerException e) { }
			 
		 
		
		if(type.equals("-")) {
			type = "Admin";
		}
		if(type.equals("Admin")) {
		
			System.out.println("1. Information about yourself" + "\n" +
				     "2. Add user\n" +
				     "3. Remove user\n" +
				     "4. Update user\n" +
				     "5. Logout");
			String action = sc.next();
			while(!action.equals("5")) {
				switch (action) {
					case ("2"):
						adminAdd();
					break;
				}
				System.out.println("1. Information about yourself" + "\n" +
					     "2. Add user\n" +
					     "3. Remove user\n" +
					     "4. Update user\n" +
					     "5. Logout");
				action = sc.next();
			}
		}
		else if(type.equals("Student")) {
			Student stud = null;
			for(Student s : Data.students) {
				if(s.getLogin().equals(login)) {
					stud = s;
					break;
				}
			}
			sessionStudent();
		}
		
		Data.Save();
	}
	static  void sessionStudent() {
        String ans = "";
        while(!ans.equals("6")) {
	
	        System.out.println("1. Courses");
	        System.out.println("2. Transcript");
	        System.out.println("3. News");
	        System.out.println("4. Registration");
	        System.out.println("5. Post News");
	        System.out.println("6. Log out");
	
	        ans = sc.nextLine();
	
	        switch (ans) {
	            case "1":
	                
	                break;
	            case "2":
	
	                break;
	            case "3":
	                
	                break;
	            case "4":
	
	                break;
	            case "5":
	                
	                break;
	        }
        }
    }
	static void adminAdd() {
		
            System.out.println("Who do you want to add?");
            System.out.println("1. Student");
            System.out.println("2. Teacher");
            System.out.println("3. Manager");
            
            String tp = "";
          
            	String ans = sc.next();
	            switch (ans) {
		            case "1":
		                tp = "Student";
		                break;
		            case "2":
		                tp = "Teacher";
		                break;
		            case "3":
		                tp = "Manager";
		                
		                break;
		            
		            default:
		                System.out.println("Invalid option!");
		                break;
		                
	            }

            
            System.out.println("Enter lastname");

            String lname = sc.next();

            System.out.println("Enter firstname");

            String name = sc.next();

            System.out.println("Enter login");

            String login = sc.next();
            System.out.println("Enter password");
            String psw = sc.next();
            
            if(tp.equals("Student")) {
            	Student s = new Student(lname,name,login); 
            	s.setPassword(psw);
            	Data.admin.addStudent(s);
            }
            else if(tp.equals("Teacher")) {
            	Teacher s = new Teacher();
            	s.setPassword(psw);
            	s.setLogin(login);
            	s.setFirstName(name);
            	s.setLastName(lname);
            	Data.admin.addTeacher(s);
            }
            else if(tp.equals("Manager")) {
            	Manager s = new Manager();
            	s.setPassword(psw);
            	s.setLogin(login);
            	s.setFirstName(name);
            	s.setLastName(lname);
            	Data.admin.addManager(s);
            }
            
    
        
	}	
}
