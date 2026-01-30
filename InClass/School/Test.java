import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("Math");
        courses.add("Physics");
        courses.add("Programming");
        Student s1 = new Student("Alice", 20, "S12345", "Computer Science", courses);
        s1.showInfo();
    }
}