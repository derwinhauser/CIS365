/*
CourseTest.java
*/

import java.util.Map;
import java.util.HashMap;  // "cis232"-> Course CIS232

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

import java.util.ArrayList;


public class CourseTest{
	// varables
	private static Map<String,Course> map_course = new HashMap<String,Course>();
	private static ArrayList<String> course_ids = new ArrayList<String>();
	private static ArrayList<Course> courses = new ArrayList<Course>();

	// main
	public static void main(String[] args) throws IOException{
		String[] temp;
		int pos=0;
		File f1 = new File("courses.csv");
		Scanner sc = new Scanner(f1);
	
		while (sc.hasNextLine()){
			temp=sc.nextLine().split(",");
			course_ids.add(temp[0]);
			courses.add(new Course(temp[0],temp[1],temp[2]));
			pos = course_ids.size()-1;
			map_course.put(course_ids.get(pos),courses.get(pos));
		}
		sc.close();

		showCourseIds();
		showCourses();

		FileWriter f2 = new FileWriter("courses.csv",true); 
		f2.write("\nCIS259,Python and Data Analysis,The course teachss data analysis"); 
		f2.close();
	}

	private static void showCourses(){
		for (int i=0; i<courses.size(); i++){
			print(courses.get(i).getId()+": "+courses.get(i).getTitle()+"\n");
		}
	}

	private static void showCourseIds(){
		for (int i=0; i<course_ids.size(); i++){
			print(course_ids.get(i)+"\n");
		}
	}

	private static void print(String s){
		System.out.print(s);
	}
}
