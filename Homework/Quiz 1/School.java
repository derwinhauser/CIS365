/* School.java

Students: 
name,age,id,major,courses<String>; 
enrollCourse(),showInfo(),listCourses();

Teachers: 
name,age,id,subject,students<Student>; 
assignStduent(), displayStudents(), showInfo()

*/

public class School{
	// main
	public static void main(String[] args){
		showMenu();		

	}

	// 
	private static void showMenu(){
		print("\n=== School Management System ===\n\n");
		print("1. Add new student\n");
		print("2. Add new teacher\n");
		print("3. list teachers\n");
		print("4. list students\n");
		print("0. Exit\n\n");

		print("=================================\n");

	}
	
	private static void print(String s){
		System.out.print(s);
	}
}