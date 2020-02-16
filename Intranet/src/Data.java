
import java.io.*;

import java.util.*;
public final class Data implements Serializable{
	 static public Vector<Student> students = new Vector <Student> ();	
	  public static Vector<Teacher> teachers = new Vector<Teacher> ();
	 public static Vector<Manager> managers = new Vector<Manager> ();
	 static public Vector <News> news;
	 static public Admin admin;
	 static public Vector <News> newsInQueue; 
	 static public HashMap <String,String> loginPassword ; 
	 static public void deserializeStudents() throws FileNotFoundException, IOException, ClassNotFoundException {
		 try {
			 ObjectInputStream ois = new ObjectInputStream (new FileInputStream ("students.txt"));
			 students = (Vector <Student>)ois.readObject();
		 } catch (EOFException e) {

		 }
	 }
	 public static  void serializeStudents () throws FileNotFoundException, IOException {
		 ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream ("students.txt"));
		 oos.writeObject(students);
		 oos.close();
	 }
	 public static  void serializeTeachers () throws FileNotFoundException, IOException {
		 ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream ("teachers.txt"));
		 oos.writeObject(teachers);
		 oos.close(); 
	 }
	 public static  void serializeNews () throws FileNotFoundException, IOException {
		 ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream ("news.txt"));
		 oos.writeObject(news);
		 oos.close();
	 }
	 public static  void serializeManager () throws FileNotFoundException, IOException {
		 ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream ("managers.txt"));
		 oos.writeObject(managers);
		 oos.close();
	 }
	 public static  void serializeNewsInQueue () throws FileNotFoundException, IOException {
		 ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream ("newsinqueue.txt"));
		 oos.writeObject(newsInQueue);
		 oos.close();
	 }
	 //(String lastName, String firstName, String login) 
	 public static void deserializeAdmin () {
		 admin = new Admin("123","321","admin1");
		 admin.setPassword("12345"); 
	 }
	 public static void deserializeNews () throws IOException, ClassNotFoundException {
		 try {
			 ObjectInputStream oos = new ObjectInputStream (new FileInputStream ("news.txt"));
			 news = (Vector <News>)oos.readObject();
			 oos.close();
		 } catch (EOFException e) {

		 }
	 }
	 public static void deserializeTeachers () throws FileNotFoundException, IOException, ClassNotFoundException {
		 try {ObjectInputStream oos = new ObjectInputStream (new FileInputStream ("teachers.txt"));
		 teachers = (Vector <Teacher>)oos.readObject();
		 oos.close();
		 }catch (EOFException e) {

		 }
	 }
	 public static void deserializeManager () throws FileNotFoundException, IOException, ClassNotFoundException {
		 try { ObjectInputStream oos = new ObjectInputStream (new FileInputStream ("managers.txt"));
		 managers = (Vector <Manager>)oos.readObject();
		 oos.close();
		 }catch (EOFException e) {

		 }
	 }
	 public static void deserializeNewsInQueue () throws IOException, ClassNotFoundException {
		 try { ObjectInputStream oos = new ObjectInputStream (new FileInputStream ("newsinqueue.txt"));
		 newsInQueue = (Vector <News>)oos.readObject();
		 oos.close();
		 } catch (EOFException e) {

		 }
	 }
	 static void DSirlz() throws FileNotFoundException, ClassNotFoundException, IOException {
		 deserializeStudents();
			deserializeAdmin();
			deserializeNews();
			deserializeTeachers();
			deserializeManager();
			deserializeNewsInQueue();
			fillLogins();
		
	 }
	 static void Save() throws FileNotFoundException, IOException {
		serializeStudents();
		serializeNews();
		serializeTeachers();
		serializeManager();
		serializeNewsInQueue();
	 }
	 
	 public static void fillLogins() {
		 try {
			 for(Student s : students) {
				 loginPassword.put(s.getLogin(), s.getPassword());
			 }
		 }
		 catch (NullPointerException e) {
			 
		 }
		 try {
			 for(Manager s : managers) {
				 loginPassword.put(s.getLogin(), s.getPassword());
			 }
		 }
		 catch (NullPointerException e) {
			 
		 }
		 try {
			 for(Teacher s : teachers) {
				 loginPassword.put(s.getLogin(), s.getPassword());
			 }
		 }
		 catch (NullPointerException e) {
			 
		 }
		 try {
			 loginPassword.put(admin.getLogin(),admin.getPassword());
		 }
		 catch (NullPointerException e) {
			 System.out.println(admin.getLogin() + " " + admin.getPassword());
		 }
		 
	 }
}
