import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Manager extends Employee  {

    public void addCourse(Course course, Teacher teacher) {
            int index = Data.teachers.indexOf(teacher);
            Data.teachers.elementAt(index).addCourse(course);
    }
    Manager() {
    	
    }
    public String viewInfosAboutTeachersAndStudents() {
        String s = "Teachers: ";
        Collections.sort(Data.teachers);
        for (int i = 0; i < Data.teachers.size(); i++) {
            Teacher teacher = Data.teachers.elementAt(i);
            s += ((i + 1) + ")" + teacher.toString() + "\n");
        }
        Collections.sort(Data.students);
        s += "Students: ";
        for (int i = 0; i < Data.students.size(); i++) {
            Student student = Data.students.elementAt(i);
            s += ((i + 1) + ")" + student.toString() + "\n");
        }
        return s;
    }

    
}