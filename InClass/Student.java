public class Student extends Human{
    private String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    public Student(int age, String name, String major) {
        super(name, age);
        this.major = major;
    }

    public Student() {
        super();
        this.major = "Undeclared";
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void introduce() {
        super.introduce();
        System.out.println("I am majoring in " + major + ".");
    }
}