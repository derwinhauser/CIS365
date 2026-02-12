/*
Student.java

*/

import java.util.ArrayList;

class Student extends Person{
	// properties
	private String id;
	private String major;
	private ArrayList<String> courses;

	// constructors
	public Student(String name,int age,String id, String major){
		super(name,age);
		this.id = id;
		this.major = major;
		this.courses = new ArrayList<String>();
	}


	// methods
	public void showInfo(){
		System.out.println("\n### Student Info ###");
		super.showInfo();
		System.out.println("Id: "+id+", Major: "+major);
		listCourses();
	}

	private void listCourses(){
		System.out.print("Courses: ");
		for (int i=0; i<courses.size(); i++){
			System.out.print(courses.get(i)+",");
		}
		System.out.println();
	}

	public void enrollCourse(String course){
		courses.add(course);
	}	


}



















