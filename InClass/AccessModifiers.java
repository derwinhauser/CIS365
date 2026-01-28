//AccessModifiers.java

public class AccessModifiers {
    //properties
    private int age;
    int weight;

    //constructors
    public AccessModifiers(int age, int weight) {
        this.age = age;
        this.weight = weight;
    }

    //getters and setters
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }


    //methods
    public void intro(){
        greeting();
        System.out.println("Age is: " + age);
        System.out.println("Weight is: " + weight);
    }

    private void greeting(){
        System.out.println("Hello, greeting... ");
    }

}