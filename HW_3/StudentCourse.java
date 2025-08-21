package dev.m3s.programming2.homework3;


import java.time.Year;

public class StudentCourse {
    private Course course;
    private int gradeNum;
    private int yearCompleted;

    public StudentCourse() {
    }

    public StudentCourse(Course course, final int gradeNum, final int yearCompleted) {
        setCourse(course);
        setGrade(gradeNum);
        setYear(yearCompleted);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGradeNum() {
        return gradeNum;
    }

    protected void setGrade(int gradeNum) {
        if (checkGradeValidity(gradeNum)) {
            if (course.isNumericGrade()) {
                if ((gradeNum == ConstantValues.GRADE_FAILED) ||
                    (gradeNum == ConstantValues.GRADE_ACCEPTED)) {
                this.gradeNum = gradeNum;
                }


            } else {
                this.gradeNum = gradeNum;
            }
        }
        if (yearCompleted == 0) {
            this.yearCompleted = getCurrentYear();
        }
    }
    

    private boolean checkGradeValidity(final int gradeNum) {
        if (course.isNumericGrade()) {
            if (ConstantValues.MIN_GRADE <= gradeNum &&
            gradeNum <= ConstantValues.MAX_GRADE) {
            return true;
        }
        } else {
            if (gradeNum == (int) ConstantValues.GRADE_ACCEPTED || gradeNum == (int) ConstantValues.GRADE_FAILED) {
            return true;
            }
        }
        return false;
    }


    public boolean isPassed() {
        boolean isPassed = gradeNum != ConstantValues.MIN_GRADE;
        char gradeNumChar = (char) gradeNum;
        if (gradeNumChar == ConstantValues.GRADE_FAILED) {
            isPassed = false;
        }
        return isPassed;
    }


    public int getYear() {
        return yearCompleted;
    }

    public void setYear(final int year) {
        int currentYear = getCurrentYear();
        if (year >= 2000 &&
        year <= currentYear) {
            this.yearCompleted = year;
        } 
    }

    private int getCurrentYear() {
        return Year.now().getValue();
    }

    private String printGrade() {
        if (!course.isNumericGrade()) {
            return String.valueOf((char) gradeNum);
        }
        return String.valueOf(gradeNum);
    }

    @Override
    public String toString() {
        return course + " Year: " + yearCompleted +
                ", Grade: " + printGrade() + ".]";

    }
          
}





