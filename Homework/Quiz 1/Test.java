/*
Test.java
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Test{
	// main
	public static void main(String[] args) throws IOException{
		
		Person p1 = new Person("John",18);
		
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		p1.showInfo();

		Student s1 = new Student("Mary",19,"s010001","CIS");
		s1.showInfo();


		s1.enrollCourse("CIS232");
		s1.enrollCourse("MAT102");
		s1.enrollCourse("CIS265");
		s1.showInfo();
				
		Student s2 = new Student("Tom",18,"s020001","MAT");
		Teacher t1 = new Teacher("DR. T",35,"t0001","Computer Science");
		t1.showInfo();
		t1.assignStudent(s1);
		t1.assignStudent(s2);
		t1.showInfo();
	}

	private static ArrayLis t<Course> readCourses() throws IOException{
		ArrayList<Course> courses= new ArrayList<Course>();
		ArrayList<String> lines = new ArrayList<String>();
		File f1 = new File("courses.csv");
		Scanner sc = new Scanner(f1);
		String temp = "";
		String[] temp_course;
		while (sc.hasNextLine()){
			temp=sc.nextLine();
			//print(temp);
			temp_course = temp.split(",");
			showArray(temp_course);
			courses.add(new Course(temp_course[0],temp_course[1],temp_course[2]));
		}
	
		return courses;
	}

	private static void print(String s){
		System.out.println(s);
	}

	private static void showArray(String[] ss){
		for (int i=0; i<ss.length; i++){
			print(ss[i]);
		}
	}

	private static String[] getCourseList(ArrayList<Course> a){
		String[] temp = new String[a.size()];
		for (int i=0; i<temp.length; i++){
			temp[i]=a.get(i).getId();
		}
		return temp;
	}
}