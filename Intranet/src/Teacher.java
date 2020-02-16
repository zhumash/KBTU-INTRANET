
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Vector;

public class Teacher extends Employee implements Comparable {
    Teacher(String login, String password, String name, String lastname, int salary) {
		super(login, password, name, lastname, salary);
		// TODO Auto-generated constructor stub
	}
    Teacher () {

    }
	private Vector<Student> students;
    private Vector<Course> courses;
    private Vector<String> messages;


   
    public void addCourse(Course course) {
    	courses.add(course);
    }

    
    
    public String viewCourse() {
        String s = "";
        for (int i = 0; i < courses.size(); ++i)
            s = s + courses.elementAt(i).toString();
        return s;
    }

    public void removeCourse(Course course) {
        for (int i = 0; i < courses.size(); ++i)
            if (courses.elementAt(i).equals(course)) {
            	courses.removeElementAt(i);
                return;
            }
    }

    public String getStudentsInCourse(Course course) {
        String s = "";
        for (int i = 0; i < courses.size(); ++i) {
            if (courses.elementAt(i).equals(course)) {
                Vector<Student> students = (courses.elementAt(i)).getStudents();
                for (int j = 0; j < students.size(); ++j)
                    s = s + students.elementAt(j).toString();
                break;

            }
        }
        return s;
    }

    public void addStudentToCourse(Course course, Student student) {
        for (int i = 0; i < courses.size(); ++i) {
            if (courses.elementAt(i).equals(course)) {
            	courses.elementAt(i).addStudent(student);
                break;
            }
        }
    }
    public String getAllStudents(){
        String s="";
        for (int i=0;i<students.size();++i)
            s+=students.elementAt(i);
        return s;
    }


    public void putMarkToStudentInCourse(Course course, Student student, double mark) {
        for (int i = 0; i < courses.size(); ++i) {
            if (courses.elementAt(i).equals(course)) {
                Vector<Student> students = (courses.elementAt(i)).getStudents();
                for (int j = 0; j < students.size(); ++j) {
                    if (students.elementAt(j).equals(student)) {
                        students.elementAt(j).setScores(course, mark);
                        break;
                    }
                }
                break;

            }
        }
    }
    
    public Course getCourse(String courseName){
        Course course2=new Course();
        for (int i=0;i<courses.size();++i)
            if (courses.elementAt(i).GetCourseName().equals(courseName))
                course2=courses.elementAt(i);
            return course2;
    }
    
    public Student getStudent(String id){
        Student student1=new Student();
        for (int i=0;i<students.size();++i)
            if (students.elementAt(i).getID().equals(id))
              student1=students.elementAt(i);
            return student1;
    }

    
    @Override
    public int compareTo(Object o){
        Teacher teacher=(Teacher)o;
        return super.getFirstName().compareTo(teacher.getFirstName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass())
            return false;
        else
            return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}