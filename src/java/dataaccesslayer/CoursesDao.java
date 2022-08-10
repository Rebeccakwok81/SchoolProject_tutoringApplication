/**
 * Student Name: Sze Man Kwok
 * Student Number: 41039774
 * Course & Section #: 22S_CST8288_011
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 * Description: This is the interface class of RecipientsDao which contain a
 * list of method. 
 * of the database.
 * @author szeman
 */
package dataaccesslayer;

import java.util.List;


import transferobjects.Course;

public interface CoursesDao {
	List<Course> getAllCourses();
	Course getCourseByCourseCode(String courseCode);
	void addCourse(Course course);
	void updateCourse(Course course);
	void deleteCourse(Course course);
}
