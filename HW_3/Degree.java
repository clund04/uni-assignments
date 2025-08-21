package dev.m3s.programming2.homework3;

import java.util.ArrayList;
import java.util.List;

public class Degree {
    static final int MAX_COURSES = 50;
    private int count = 0;
    private String degreeTitle = ConstantValues.NO_TITLE;
    private String titleOfThesis = ConstantValues.NO_TITLE;
    private List<StudentCourse> myCourses = new ArrayList<StudentCourse>();

    public List<StudentCourse> getCourses() {
        return myCourses;
    }

    public void addStudentCourses(List<StudentCourse> courses) {
        if (courses != null) {
            for (StudentCourse course : courses) {
                if (count < MAX_COURSES &&
                course != null) {
                    addStudentCourse(course);
                }
            }
        }
    }
    
    public boolean addStudentCourse(StudentCourse course) {
        if (course != null && count < MAX_COURSES) {
            myCourses.add(course);
            this.count++;
            return true;
        }
    return false;
    }

     

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        if (degreeTitle != null) {
            this.degreeTitle = degreeTitle;
        }
    }

    public String getTitleOfThesis() {
        return titleOfThesis;
    }

    public void setTitleOfThesis(String titleOfThesis) {
        if (titleOfThesis != null) {
            this.titleOfThesis = titleOfThesis;
        }
    }

    public double getCreditsByBase(Character base) {
        double totalCreditsByBase = 0.0;
        for (StudentCourse course: myCourses) {
            if (course != null && course.isPassed() && course.getCourse().getCourseBase().equals(base)) {
                totalCreditsByBase += course.getCourse().getCredits();
            }            
        }
        return totalCreditsByBase;
    }

    public double getCreditsByType(final int courseType) {
        double totalCreditsByType = 0.0;
        for (StudentCourse course: myCourses) {
            if (course != null && course.isPassed() && course.getCourse().getCourseType() == courseType) {
                totalCreditsByType += course.getCourse().getCredits();
            }
        }
        return totalCreditsByType;
    }

    public double getCredits() {
        double totalCredits = 0.00;

        for (StudentCourse course: myCourses)  {
            if (course != null) {
                double credits = course.getCourse().getCredits();

                if (isCourseCompleted(course)) {
                    totalCredits += credits;
                }
            }
        }
        return totalCredits;
    }

    private boolean isCourseCompleted(StudentCourse c) {
        if (c != null) {
            if (c.getCourse().isNumericGrade()) {  
                return c.getGradeNum() >= 1;
            } else {  
                return c.getGradeNum() == ConstantValues.GRADE_ACCEPTED;
            }
        }
        return false;
    }
    

    public void printCourses() {
        for (StudentCourse course : myCourses) {
            if (course != null) {
            System.out.println(course);
            }
        }
    }

    public List<Double> getGPA(int type) {
        double sum = 0.0;
        int count = 0;

        for (StudentCourse c : myCourses) {
            if (c.getCourse().isNumericGrade()) {
                sum += c.getGradeNum();
                count++;
            }
        }
        List<Double> listGPA = new ArrayList<>();
        double avg = 0.0;
        if (count > 0) {
            avg = sum / count;
        }
        listGPA.add(avg);
        listGPA.add((double)count);
        listGPA.add(sum);
        
        return listGPA;
    }

    public int getCount() {
        return count;
    }
    
    public static int getMaxCourses() {
        return MAX_COURSES;
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Degree [Title: \"").append(degreeTitle).append("\" (courses: ").append(count).append(")\n");
        sb.append("\tThesis title: \"").append(titleOfThesis).append("\"]\n");
    
        for (StudentCourse course : myCourses) {
            if (course != null) {
                sb.append(course.toString()).append("\n");
            }
        }
    
        return sb.toString();
    }

    
}
