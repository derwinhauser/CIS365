import java.util.Map;
import java.util.HashMap; // "cis232 -> Course CIS232"
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CourseTest {
    //variables
    private static Map<String, Course> mapCourse = new HashMap<String, Course>();
    private static ArrayList<String> courseIds = new ArrayList<String>();
    private static ArrayList<Course> courses = new ArrayList<Course>();

    //main
    public static void main(String[] args) throws IOException {
        String [] temp;
        int pos;
        File f1 = new File("courseList.csv");
        Scanner sc = new Scanner(f1);

        while (sc.hasNextLine()) {
            temp = sc.nextLine().split(",");
            courseIds.add(temp[0]);
            courses.add(new Course(temp[0], temp[1], temp[2]));
            pos = courseIds.size() - 1;
            mapCourse.put(courseIds.get(pos), courses.get(pos));
        }
        sc.close();
        showCourseIds();
        showCourses();

    }

    private static void showCourses() {
        for (Course c : courses) {
            print(c.getId() + " " + c.getTitle() + "\n");
        }
    }

    private static void showCourseIds() {
        for (String id : courseIds) {
            print(id + "\n");
        }
    }

    private static void print(String s) {
        System.out.print(s);
    }
}