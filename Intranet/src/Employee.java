
public class Employee extends User  {
    private int salary;

    Employee () {
    	
    }
    Employee(String login, String password, String name, String lastname,
             int salary) {
        super(lastname, name,login);
        this.salary = salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
    	
        return "FullName: " + super.getFullName() + "\n" +
                "id: " + super.getID() + "\n" +
                "salary: " + this.getSalary();
    }
}