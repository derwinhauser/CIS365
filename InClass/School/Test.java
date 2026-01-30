public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        System.out.println(p1.getName());
        System.out.println(p1.getAge());
        p1.showInfo();
    }
}