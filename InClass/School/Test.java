import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("MATH101", "Mathematics", "Intro to Math"));
        courses.add(new Course("PHYS201", "Physics", "Intro to Physics"));
        courses.add(new Course("CS301", "Programming", "Intro to Programming"));
        Student s1 = new Student("Alice", 20, "S12345", "Computer Science", courses);
        
        s1.showInfo();
        s1.enrollCourse(new Course("ENG101", "English", "Intro to English"));
        s1.showInfo();

        Teacher t1 = new Teacher("Mr. Smith", 40, "T67890", "Mathematics");
        t1.addStudent(s1);
        t1.showInfo();
    }    

    private static ArrayList<Course> readCourses() throws IOException {
        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<String> lines = new ArrayList<String>();
        File f1 = new File("courselist.csv");
        Scanner sc = new Scanner(f1);
        String temp = "";
        String[] tempCourse;
        while (sc.hasNextLine()) {
            temp = sc.nextLine();
            tempCourse = temp.split(",");
            courses.add(new Course(tempCourse[0], tempCourse[1], tempCourse[2]));
        }

        sc.close();
        return courses;
    }
    private static void writeCourses(ArrayList<Course> courses) throws IOException {
        File f1 = new File("courselist.csv");
        FileWriter fw = new FileWriter(f1);
        for (Course course : courses) {
            fw.write(course.getId() + "," + course.getTitle() + "," + course.getInfo() + "\n");
        }
        fw.close();
    }
}