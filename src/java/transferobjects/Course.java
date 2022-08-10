/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transferobjects;

//import Tutoring.BusinessObjects.CourseBuilder;

/**
 * This is the Course class which contain the getter and setter to create
 * a course.
 * @author fredmacedo szeman
 */
public class Course {
    private String courseCode;
    private String courseName;
    private String courseDescription;
    
  /*   public Course(CourseBuilder builder) {
         courseCode = builder.getCourseCode();
         courseName = builder.getCourseName();
         courseDescription = builder.getCourseDescription();
    
    }
     
    private Course(){
        
    } */
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String curseCode) {
        this.courseCode = curseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String curseName) {
        this.courseName = curseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String curseDescription) {
        this.courseDescription = curseDescription;
    }
    
    @Override
    public String toString() {
        
      return  String.format("Course Code: %s%n Couser Name: %s%n Couser Description: ", courseCode, courseName, courseDescription);
            
    }
    
     
}

