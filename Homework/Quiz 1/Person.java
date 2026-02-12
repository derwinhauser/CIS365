/*
Person.java

*/


class Person{
	// properties
	protected String name;
	protected int age;

	// constructors
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}

	// methods
	public String getName(){
		return name;
	}

	public int getAge(){
		return age;
	}

	public void showInfo(){
		System.out.println("Name: "+name+", age: "+age);
	}
}