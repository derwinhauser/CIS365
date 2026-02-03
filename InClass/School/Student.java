/*
Student.java
*/
import java.util.ArrayList;

public class Student extends Person {
    // properties
    private String studentId;
    private String major;
    private ArrayList<Course> courses;

    // constructor
    public Student(String name, int age, String studentId, String major, ArrayList<Course> courses) {
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

    public ArrayList<Course> getCourses() {
        return courses;
    }

    private void printCourses() {
        System.out.println("Courses enrolled:");
        for (Course course : courses) {
            System.out.println("- " + course.getTitle());
        }
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println("Major: " + major);
        printCourses();
    }

    public void enrollCourse(Course course) {
        courses.add(course);
        System.out.println("Enrolled in course: " + course);
    }
}