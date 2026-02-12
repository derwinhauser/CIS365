
// InheritanceTest.java
public class InheritanceTest{
    // main
    public static void main(String[] args){
        Student student1 = new Student();
        Student student2 = new Student("John",18,"Computer Science");
        // please complete the rest code
        System.out.print("Student 1: ");
        student1.printInfo();
        System.out.print("Student 2: ");
        student2.printInfo();
        System.out.println("**** After change ****");
        student1.setName("Mary");
        student1.setAge(22);
        student1.setMajor("Math");
        System.out.print("Student 1: ");
        student1.printInfo();
        student1.greeting();

    }
}
