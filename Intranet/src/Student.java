import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
public class Student extends User implements Serializable,Comparable {
	Student () {
		
	}

    private int yearOfStudy = 1;
    private double gpa;
    private HashMap<Course,CourseStatus> courses; 
    private HashMap<Course,Double> scoresForPassedCourses; 
    private HashMap <Course,Double> scoresForCourses;
    public Student(String lastName, String firstName, String login) {
        super(lastName, firstName, login);
    }
    public String viewPassedCourses() {
    	String res = "";
    	for(Course c : scoresForPassedCourses.keySet()) {
    		res += c.toString() + scoresForPassedCourses.get(c) + "\n";
    	}
    	return res;
    }
    void setScores(Course c,double m){
    	scoresForCourses.put(c,scoresForCourses.get(c) + m);
    }
    public String viewAtt() {
    	String res = "";
    	for(Course c : scoresForCourses.keySet()) {
    		res += c.toString() + scoresForCourses.get(c) + "\n";
    	}
    	return res;
    }

//    public Faculty getFaculty() { return faculty; }
//    public void setFaculty(Faculty faculty) { this.faculty = faculty; }

    public int getYearOfStudy() { return yearOfStudy; }
    public void setYearOfStudy(int yearOfStudy) { this.yearOfStudy = yearOfStudy; }

    public void incrementYearOfStudy() { yearOfStudy++; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    
   
 
    public String toString() {
        //String facultyInfo;
        //fa//cultyInfo = faculty.toString() + " ";
     //   String info = "Education: " + facultyInfo  + yearOfStudy + " course\n";
        return "Student\n" + super.toString();
    }

    @Override
    public boolean equals(Object obj) { return super.equals(obj); }

    @Override
    public int hashCode() { return super.hashCode(); }
	@Override
	public int compareTo(Object o) {
		Student c = (Student)o;
		if(this.gpa > c.getGpa()) 
			return 1;
		if(this.gpa <c.getGpa())
			return -1;
		return 0;
	}
}