public class Student extends Human {
    private String major;

    public Student() {
        super();
        major = "no major";
    }

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void greeting() {
        System.out.println("Hello, I am a Student, and my name is " + getName());
    }
    public void printInfo() {
        System.out.print(getName() + ", ");
        System.out.print(getAge() + " years old, ");
        System.out.println(major);
    }
}