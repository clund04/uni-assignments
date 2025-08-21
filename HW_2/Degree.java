package dev.m3s.programming2.homework2;


public class Degree {
    private static final int MAX_COURSES = 50;
    private int count = 0;
    private String degreeTitle = ConstantValues.NO_TITLE;
    private String titleOfThesis = ConstantValues.NO_TITLE;
    private StudentCourse[] myCourses = new StudentCourse[MAX_COURSES];

    public StudentCourse[] getCourses() {
        return myCourses;
    }

    public void addStudentCourses(StudentCourse[] courses) {
        if (courses != null) {
            for (StudentCourse course : courses) {
                if (count < MAX_COURSES) {
                    addStudentCourse(course);
                }
            }
        }
    }
    
    public boolean addStudentCourse(StudentCourse course) {
        if (course != null && count < MAX_COURSES) {
            myCourses[count] = course;
            count++;
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
