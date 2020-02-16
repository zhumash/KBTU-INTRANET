import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Course implements  Serializable {
    private String courseName;
    private String code;
    private Vector<Teacher> teachers;
    private Vector<Student> students;
    private int creditNumber;
    private CourseStatus statuse;
    private Vector<CourseFile> files;
    public void addStudent(Student student) {
        this.students.add(student);
    }
    Vector <Student> getStudents() {
    	return students;
    }
    public String GetCourseName() {
    	return courseName; 
    }

    @Override
    public String toString() {
        String nameInfo = "Course: " + courseName + " ";
        String idInfo = "Course code: " + code + " ";
        String creditInfo = "Credit number: " + creditNumber + '\n';
        return idInfo + nameInfo+ creditInfo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return  true;
        if (!(obj instanceof Course)) return false;
        Course c = (Course) obj;
        return c.code.equals(code);
    }

    @Override
    public int hashCode() { return code.hashCode(); }
}