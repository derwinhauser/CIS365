/*
Course.java
properties: id,title,info
*/

public class Course{
	// properties
	String id;
	String title;
	String info;

	// constructors
	public Course(String id,String title, String info){
		this.id = id;
		this.title = title;
		this.info = info;
	}

	// methods
	public String getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getInfo(){
		return info;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public void setInfo(String info){
		this.info = info;
	}

}