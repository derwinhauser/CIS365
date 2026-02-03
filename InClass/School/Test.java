import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("MATH101", "Mathematics", "Intro to Math"));
        courses.add(new Course("PHYS201", "Physics", "Intro to Physics"));
        courses.add(new Course("CS301", "Programming", "Intro to Programming"));
        Student s1 = new Student("Alice", 20, "S12345", "Computer Science", courses);
        s1.showInfo();
    }
}