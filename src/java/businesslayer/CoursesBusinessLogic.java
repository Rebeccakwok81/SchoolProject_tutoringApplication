/* File: StudentsBusinessLogic.java
 * AuthorDTO: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern with Servlet website
 */
package businesslayer;

import java.util.List;
import dataaccesslayer.CoursesDao;
import dataaccesslayer.CoursesDaoImpl;
import transferobjects.Course;
import transferobjects.CredentialsDTO;

public class CoursesBusinessLogic {
	private static final int COURSE_CODE_MAX_LENGTH = 30;
	private static final int COURSE_NAME_MAX_LENGTH = 30;
        
	private CoursesDao coursesDao = null;
	private CredentialsDTO creds;
	public CoursesBusinessLogic(CredentialsDTO creds){
		coursesDao = new CoursesDaoImpl(creds);
	}
	
	public List<Course> getAllCourses(){
		return coursesDao.getAllCourses();
	}
	
	public Course getCourseCode(String courseCode){
		return coursesDao.getCourseByCourseCode(courseCode);
	}
	
	public void addCourse(Course course) throws ValidationException{
		cleanCourse(course);
		validateCourse(course);
		coursesDao.addCourse(course);
	}
	
	public void updateCourse(Course course) throws ValidationException{
		cleanCourse(course);
		validateCourse(course);
		coursesDao.updateCourse(course);
	}
	
	public void deleteCourse(Course course){
		coursesDao.deleteCourse(course);
	}
	
	private void cleanCourse(Course course){
		if(course.getCourseCode() != null){ 
			course.setCourseCode(course.getCourseCode().trim());
		}
		if(course.getCourseName() != null){ 
			course.setCourseName(course.getCourseName().trim());
		}
	}
	
	private void validateCourse(Course course) throws ValidationException{
		validateString(course.getCourseCode(), "Course Code", COURSE_CODE_MAX_LENGTH, true);
		validateString(course.getCourseName(), "Course Name", COURSE_NAME_MAX_LENGTH, true);
	}
	
	private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed)
	    throws ValidationException{
		if(value == null && isNullAllowed){
			// return; // null permitted, nothing to validate
		}
		else if(value == null && ! isNullAllowed){
		    throw new ValidationException(String.format("%s cannot be null", 
		    		fieldName));
		}
		else if(value.length() == 0){
			throw new ValidationException(String.format("%s cannot be empty or only whitespace", 
					fieldName));
		}
		else if(value.length() > maxLength){
			throw new ValidationException(String.format("%s cannot exceed %d characters", 
					fieldName, maxLength));
		}
	}
	/*
	private void validateInt(int value, String fieldName)
	    throws ValidationException{
		if(value <= 0){
			throw new ValidationException(String.format("%s cannot be a negative number", 
					fieldName));
		}
	}
	*/
}
