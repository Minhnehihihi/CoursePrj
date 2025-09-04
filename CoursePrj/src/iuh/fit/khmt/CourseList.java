package iuh.fit.khmt;
/**
 * @description:  
 * @author:      Trần Quang Minh
 * @version:     1.0
 * @created:     Sep 4, 2025 8:25:22 PM
 */


import java.util.*;
	
	public class CourseList {
		    private int count = 0;
		    private Course[] courses;

		    
		    public CourseList(int size) {
		        if (size <= 0) {
		            throw new IllegalArgumentException("Length of the array must be greater than 0");
		        }
		        courses = new Course[size];
		    }


		    
		    public boolean addCourse(Course course) {
		        if (count >= courses.length || exist(course)) {
		            return false;
		        }
		        courses[count] = course;
		        count++;
		        return true;
		    }



		    public boolean exist(Course course) {
		        for (int i = 0; i < count; i++) {
		            if (courses[i].getId().equals(course.getId())) {
		                return true;
		            }
		        }
		        return false;
		    }



		    public String findDepartmentWithMostCourses() {
		        Map<String, Integer> deptCount = new HashMap<>();
		        for (int i = 0; i < count; i++) {
		            String dept = courses[i].getDepartment();
		            deptCount.put(dept, deptCount.getOrDefault(dept, 0) + 1);
		        }

		        String maxDept = null;
		        int max = 0;
		        for (Map.Entry<String, Integer> entry : deptCount.entrySet()) {
		            if (entry.getValue() > max) {
		                max = entry.getValue();
		                maxDept = entry.getKey();
		            }
		        }
		        return maxDept;
		    }

		    
		    public Course[] findMaxCreditCourses() {
		        int max = 0;
		        for (int i = 0; i < count; i++) {
		            if (courses[i].getCredit() > max) { 
		                max = courses[i].getCredit();
		            }
		        }

		        List<Course> maxCourses = new ArrayList<>();
		        for (int i = 0; i < count; i++) {
		            if (courses[i].getCredit() == max) { 
		                maxCourses.add(courses[i]);
		            }
		        }
		        return maxCourses.toArray(new Course[0]);
		    }


		    
		    public boolean removeCourse(String id) {
		        for (int i = 0; i < count; i++) {
		            if (courses[i].getId().equals(id)) {
		                courses[i] = courses[count - 1]; 
		                courses[count - 1] = null;
		                count--;
		                return true;
		            }
		        }
		        return false;
		    }


		    public Course searchCourse(String keyword) {
		        for (int i = 0; i < count; i++) {
		            if (courses[i].getId().equalsIgnoreCase(keyword) || 
		                courses[i].getTitle().equalsIgnoreCase(keyword)) {
		                return courses[i];
		            }
		        }
		        return null;
		    }

		    
		    public Course[] searchCourseByDepartment(String department) {
		        List<Course> result = new ArrayList<>();
		        for (int i = 0; i < count; i++) {
		            if (courses[i].getDepartment().equalsIgnoreCase(department)) {
		                result.add(courses[i]);
		            }
		        }
		        return result.toArray(new Course[0]);
		    }

		    
		    public Course searchCourseById(String id) {
		        for (int i = 0; i < count; i++) {
		            if (courses[i].getId().equals(id)) {
		                return courses[i];
		            }
		        }
		        return null;
		    }

		    
		    public Course[] sortCourses() {
		        Course[] sorted = Arrays.copyOf(courses, count);
		        Arrays.sort(sorted, Comparator.comparing(Course::getId));
		        return sorted;
		    }

		    
		    public Course[] getCourses() {
		        return Arrays.copyOf(courses, count);
		    }
		}


