import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Admin extends User {
    
    public  void addStudent(Student s){
        Data.students.add(s);   
    }
    public  void addManager(Manager m) {
    	Data.managers.add(m);
    }
    public  void addTeacher(Teacher t) {
    	Data.teachers.add(t);
    }
    Admin(String lastName,String firstName,String login) {
    	super(lastName,firstName,login);
    	
    }
    public static void removeUser(User user, String type){
        if(type.equals("teacher")){
            Teacher teacher=(Teacher) user;
            Data.teachers.remove(teacher);
        }
        else if(type.equals("student")){
            Student student=(Student) user;
            Data.students.remove(student);
        }
        else if(type.equals("manager")){
            Manager manager=(Manager) user;
            Data.managers.remove(manager);
        }
    }
   
    public static String seeUserActions() throws FileNotFoundException {
        String s="";
        BufferedReader br=null;
        String inputline=null;
        try {
            br = new BufferedReader(new FileReader("userActions.txt"));
            while((inputline=br.readLine())!=null){
                s += (inputline+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}