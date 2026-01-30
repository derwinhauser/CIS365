/*
Student.java
*/
import java.util.ArrayList;

public class Student extends Person {
    // properties
    private String studentId;
    private String major;
    private ArrayList<String> courses;

    // constructor
    public Student(String name, int age, String studentId, String major, ArrayList<String> courses) {
        super(name, age);
        this.studentId = studentId;
        this.major = major;
        this.courses = courses;
    }

    // getter/setter
    public String getStudentId() {
        return studentId;
    }

    public String getMajor() {
        return major;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    private void printCourses() {
        System.out.println("Courses enrolled:");
        for (String course : courses) {
            System.out.println("- " + course);
        }
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println("Major: " + major);
        System.out.println("Courses: " + courses);
    }
}