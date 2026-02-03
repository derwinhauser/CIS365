/*
Course.java
properties: id, title, info
 */

public class Course {
    //properties
    private String id;
    private String title;
    private String info;
    //constructors
    public Course(String id, String title, String info) {
        this.id = id;
        this.title = title;
        this.info = info;
    }
    public Course(String id) {
        this.id = id;
        this.title = "Unknown";
        this.info = "No info available";
    }
    //methods
    public void displayCourseInfo() {
        System.out.println("Course ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Info: " + info);
    }
    //getters and setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    
}