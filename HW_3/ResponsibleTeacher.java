package dev.m3s.programming2.homework3;

import java.util.ArrayList;
import java.util.List;


public class ResponsibleTeacher extends Employee implements Teacher, Payment {
    private List<DesignatedCourse> courses = new ArrayList<>();

    public  ResponsibleTeacher(String lname, String fname) {
        super(lname, fname);
    }

    public String getEmployeeIdString()  {
        return "OY_TEACHER_";
    }

    public String getCourses() {
        StringBuilder sb = new StringBuilder();
        if (courses != null) {
            for (DesignatedCourse course : courses ) {
                sb.append("Responsible teacher: ").append(course.toString()).append("\n");
            }
        }
        return sb.toString();
    }
    

    public void setCourses(List<DesignatedCourse> courses) {
        if (courses != null) {
            this.courses = courses;

        }
    }

    @Override
    public String toString() {
        String tab = "\t";
        String printL = "\n";

        return "Teacher id: " + getIdString() + printL +
                tab + tab + "FirstName: " + getFirstName() + ", " +
                "LastName: " + getLastName()+ printL +
                tab + tab + "Birthdate: " + getBirthDate() + printL +
                tab + tab + "Salary: " +
                String.format("%.2f", getPayment().calculatePayment())+ printL +
                tab + tab + "Teacher for courses: " + printL +
                getCourses();
    }
    
}


