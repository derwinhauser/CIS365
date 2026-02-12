/* School.java

Students: 
name,age,id,major,courses<String>; 
enrollCourse(),showInfo(),listCourses();

Teachers: 
name,age,id,subject,students<Student>; 
assignStduent(), displayStudents(), showInfo()

*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class School{
	// variables
	private static ArrayList<String> studentNames = new ArrayList<String>();
	private static ArrayList<Integer> studentAges = new ArrayList<Integer>();
	private static ArrayList<String> studentIds = new ArrayList<String>();
	private static ArrayList<String> studentMajors = new ArrayList<String>();
	
	private static Scanner inputScanner = new Scanner(System.in);
	private static final String STUDENTS_FILE = "students.csv";
	
	// main
	public static void main(String[] args) throws IOException{
		loadStudents();
		mainMenu();
	}

	// Load students from CSV file
	private static void loadStudents() throws IOException{
		File f = new File(STUDENTS_FILE);
		if (!f.exists()){
			f.createNewFile();
			return;
		}
		
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()){
			String line = sc.nextLine().trim();
			if (line.isEmpty()) continue;
			
			String[] temp = line.split(",");
			if (temp.length >= 4){
				studentNames.add(temp[0]);
				studentAges.add(Integer.parseInt(temp[1]));
				studentIds.add(temp[2]);
				studentMajors.add(temp[3]);
			}
		}
		sc.close();
	}
	
	// Main menu loop
	private static void mainMenu() throws IOException{
		int choice;
		while (true){
			showMenu();
			print("Enter your choice: ");
			choice = inputScanner.nextInt();
			inputScanner.nextLine(); // consume newline
			
			switch(choice){
				case 1:
					addStudent();
					returnToHome();
					break;
				case 2:
					print("\n*** Teacher management - coming soon ***\n");
					returnToHome();
					break;
				case 3:
					print("\n*** Teacher list - coming soon ***\n");
					returnToHome();
					break;
				case 4:
					listStudents();
					returnToHome();
					break;
				case 0:
					print("\n=== Exiting School Management System ===\n");
					inputScanner.close();
					System.exit(0);
					break;
				default:
					print("\n*** Invalid choice, please try again ***\n");
					returnToHome();
			}
		}
	}

	// Display menu
	private static void showMenu(){
		print("\n=== School Management System ===\n\n");
		print("1. Add new student\n");
		print("2. Add new teacher\n");
		print("3. list teachers\n");
		print("4. list students\n");
		print("0. Exit\n\n");
		print("=================================\n");
	}
	
	// Add a new student
	private static void addStudent() throws IOException{
		print("\n--- Add New Student ---\n");
		
		print("Enter student name: ");
		String name = inputScanner.nextLine();
		
		print("Enter student age: ");
		int age = inputScanner.nextInt();
		inputScanner.nextLine(); // consume newline
		
		print("Enter student ID: ");
		String id = inputScanner.nextLine();
		
		print("Enter student major: ");
		String major = inputScanner.nextLine();
		
		// Add to arrays
		studentNames.add(name);
		studentAges.add(age);
		studentIds.add(id);
		studentMajors.add(major);
		
		// Save to file
		FileWriter fw = new FileWriter(STUDENTS_FILE, true);
		fw.write(name + "," + age + "," + id + "," + major + "\n");
		fw.close();
		
		print("\n*** Student added successfully ***\n");
	}
	
	// List all students
	private static void listStudents(){
		print("\n--- Student List ---\n");
		
		if (studentNames.isEmpty()){
			print("No students found.\n");
			return;
		}
		
		for (int i = 0; i < studentNames.size(); i++){
			print((i+1) + ". Name: " + studentNames.get(i) + 
				  ", Age: " + studentAges.get(i) + 
				  ", ID: " + studentIds.get(i) + 
				  ", Major: " + studentMajors.get(i) + "\n");
		}
	}
	
	// Return to home / main menu
	private static void returnToHome(){
		print("\nPress Enter to return to home menu...");
		inputScanner.nextLine();
	}
	
	private static void print(String s){
		System.out.print(s);
	}
}