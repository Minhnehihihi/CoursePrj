package iuh.fit.khmt;
/**
 * @description:  
 * @author:      Trần Quang Minh
 * @version:     1.0
 * @created:     Sep 4, 2025 4:38:14 PM
 */

public class Course {
    private int credit;
    private String department;
    private String id;
    private String title;

    public Course(String id, String title, int credit, String department) {
        if (id == null || id.length() < 3 || !id.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("ID must have at least 3 characters and contain only letters or digits");
        }
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit must be greater than 0");
        }

        this.credit = credit;
        this.department = department;
        this.id = id;
        this.title = title;
    }


    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit must be greater than 0");
        }
        this.credit = credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.length() < 3 || !id.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("ID must have at least 3 characters and contain only letters or digits");
        }
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("Course[ID=%s, Title=%s, Credit=%d, Dept=%s]", id, title, credit, department);
    }
}