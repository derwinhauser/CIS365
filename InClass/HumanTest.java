public class HumanTest{
    public static void main(String[] args) {
        Human person1 = new Human("Alice", 30);
        Human person2 = new Human();

        person1.introduce(); // Output: My name is Alice and I am 30 years old.
        person2.introduce(); // Output: My name is NO NAME and I am 0 years old.

        person2.setName("Bob");
        person2.setAge(25);
        person2.introduce(); // Output: My name is Bob and I am 25 years old.

        Student student1 = new Student("Charlie", 20, "Computer Science");
        Student student2 = new Student();
        student1.introduce(); // Output: My name is Charlie and I am 20 years old.
    }
}