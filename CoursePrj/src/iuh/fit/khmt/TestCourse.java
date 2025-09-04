package iuh.fit.khmt;
/**
 * @description:  
 * @author:      Trần Quang Minh
 * @version:     1.0
 * @created:     Sep 4, 2025 8:51:43 PM
 */

public class TestCourse {
   
	    public static void initData(CourseList list) {
	        list.addCourse(new Course("C101", "Java Programming", 3, "CS"));
	        list.addCourse(new Course("C102", "Data Structures", 4, "CS"));
	        list.addCourse(new Course("B201", "Microeconomics", 3, "Business"));
	        list.addCourse(new Course("M301", "Calculus", 4, "Math"));
	        list.addCourse(new Course("M302", "Linear Algebra", 4, "Math"));
	    }

	    public static void main(String[] args) {
	        CourseList courseList = new CourseList(10);
	        initData(courseList);

	        System.out.println("All courses:");
	        for (Course c : courseList.getCourses()) {
	            System.out.println(c.getId() + " - " + c.getTitle());
	        }

	        System.out.println("\nDepartment with most courses: " + courseList.findDepartmentWithMostCourses());

	        System.out.println("\nMax credit courses:");
	        for (Course c : courseList.findMaxCreditCourses()) {
	            System.out.println(c.getId() + " - " + c.getCredit() + " credits");
	        }

	        System.out.println("\nCourses sorted by ID:");
	        for (Course c : courseList.sortCourses()) {
	            System.out.println(c.getId());
	        }
	    }
	}

