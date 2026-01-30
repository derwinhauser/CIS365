/*
Person.java 
*/

public class Person {
    // properties
    protected String name;
    protected int age;

    // constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // getter/setter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void showInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}