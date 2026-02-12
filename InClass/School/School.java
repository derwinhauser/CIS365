/*

Students: name, age, id, major, courses; enrollCourse(), showInfo(), listCourses()
Teachers: name,age,id,subject,students<Student>; assignStudent(), displayStudents(), showInfo()

*/

public class School {
    //main
    public static void main(String[] args) {
        showMenu();
    }

    //methods
    public static void showMenu() {
        System.out.println("Welcome to the School Management System");
        System.out.println("1. Add Student");
        System.out.println("2. Add Teacher");
        System.out.println("3. Enroll Student in Course");
        System.out.println("4. Display Student Info");
        System.out.println("5. Display Teacher Info");
        System.out.println("6. Exit");
    }

}