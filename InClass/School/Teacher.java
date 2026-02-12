import java.util.ArrayList;

public class Teacher extends Person {
    //properties
    private String id;
    private String subject;
    private ArrayList<Student> students;

    //constructor
    public Teacher(String name, int age, String id, String subject) {
        super(name, age);
        this.id = id;
        this.subject = subject;
        this.students = new ArrayList<Student>();
    }

    //methods
    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("Students of " + getName() + ":");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("ID: " + id + ", Subject: " + subject);
        displayStudents();
    }
}