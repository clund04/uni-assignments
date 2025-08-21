package dev.m3s.programming2.homework3;

import java.util.List;
import java.util.ArrayList;
import java.time.Year;

public class Student extends Person {

    private int id = getRandomId(ConstantValues.MIN_STUDENT_ID, ConstantValues.MAX_STUDENT_ID);
    private int startYear = getCurrentYear();
    private int graduationYear;
    private final List<Degree> degrees = new ArrayList<>();
    private final int currentYear = getCurrentYear();
    private double bachelorCredits = 0.0;
    private double masterCredits = 0.0;
    private String titleOfBachelorsThesis = ConstantValues.NO_TITLE;
    private String titleOfMastersThesis = ConstantValues.NO_TITLE;

    public Student(String lastName, String firstName) {
        super(lastName,firstName);
        degrees.add(new Degree());
        degrees.add(new Degree());
        degrees.add(new Degree());
    }

    private int getCurrentYear() {
        return Year.now().getValue();
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        int min = ConstantValues.MIN_STUDENT_ID;
        int max = ConstantValues.MAX_STUDENT_ID;
        if (id >= min && id <= max) {
            this.id = id;
        }    
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(final int startYear) {
        if (2000 < startYear &&
            startYear <= currentYear) {
                this.startYear = startYear;
        }
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public String setGraduationYear(final int graduationYear) {
        if (canGraduate() && graduationYear < startYear ||
        graduationYear > currentYear) {
            return "Ok";
        }
        if (!canGraduate()) {
            return "Check amount of required credits";       
        } else {
            return "Check graduation year";
        }
       
    }

    public void setDegreeTitle(final int i, String dName) {
        if (dName != null && 0 <= i && degrees.size() > i) {
            degrees.get(i).setDegreeTitle(dName);
        }
    }

    public boolean addCourse(final int i, StudentCourse course) {
        if (course != null && 0 <= i && degrees.size() > i) {
            if (degrees.get(i).getCount() < Degree.getMaxCourses()) {
                return degrees.get(i).addStudentCourse(course);
            }
        }
        return false;
    }

    public int addCourses(final int i, List<StudentCourse> courses) {
        int addedCount = 0;
        if (0 <= i && i < degrees.size()) {
        for (StudentCourse course : courses) {
            if (course != null && degrees.get(i).getCount() < Degree.getMaxCourses()) {
                if (degrees.get(i).addStudentCourse(course)) {
                    addedCount++;
                }
            }
        }
    }
    return addedCount;
}

    public void printCourses() {
        for (Degree degree : degrees) {
            if (degree !=null) {
                for (StudentCourse course : degree.getCourses()) {
                    if (course != null) {
                        System.out.println(course);
                    }
                }
            }
        }
    }

    public void printDegrees() {
        for (Degree degree : degrees) {
            if (degree !=null) {
                System.out.println(degree);
            }
        }
    }

    public void setTitleOfThesis(final int i, String title) {
        if (degrees.get(i).getTitleOfThesis() != null && (0 <= i && i < degrees.size())) {
            degrees.get(i).setTitleOfThesis(title);
        }        
    }


    public boolean hasGraduated() {
        if (graduationYear == 0) {
            return false;
        }
        return currentYear >= graduationYear; 
    } 

    private boolean canGraduate() {
        return bachelorCredits >= ConstantValues.BACHELOR_CREDITS &&
            masterCredits >= ConstantValues.MASTER_CREDITS && 
            !this.titleOfBachelorsThesis.equals(ConstantValues.NO_TITLE) && 
            !this.titleOfMastersThesis.equals(ConstantValues.NO_TITLE);

    }

    public int getStudyYears() {
        if(hasGraduated()) {
            return this.graduationYear - this.startYear;
        }
        else {
            return this.currentYear - this.startYear;
        }
    }

    public String getIdString() {

        String IdString = "Student id: " + this.id;

        return IdString;
    }
    

    @Override
    public String toString() {
        return "Student id: " + this.id + ", Name: " + getFirstName() + " " + getLastName() +
           ", Start Year: " + this.startYear + ", Graduation Year: " + this.graduationYear + 
           ", Degrees: " + degrees.size();
    }
}






    
 

 