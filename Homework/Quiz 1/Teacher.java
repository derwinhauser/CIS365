// Teacher.java


import java.util.ArrayList;

class Teacher extends Person{
	// propeties
	private String id;
	private String subject;
	private ArrayList<Student> students;

	// constructors
	public Teacher(String name,int age,String id,String subject){
		super(name,age);
		this.id = id;
		this.subject = subject;
		this.students = new ArrayList<Student>();
	}
 
	public void assignStudent(Student s){
		students.add(s);
	}

	public void displayStudents(){
		System.out.print("students: ");
		for (int i=0; i<students.size(); i++){
			System.out.print(students.get(i).getName()+",");
		}
		System.out.println();
	}

	public void showInfo(){
		super.showInfo();
		System.out.println("ID: "+id+" ,subject: "+subject);
		displayStudents();		
	}

}