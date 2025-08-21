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
           
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(final int startYear) {
        
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public String setGraduationYear(final int graduationYear) {
        
       
    }

    public void setDegreeTitle(final int i, String dName) {
        
    }

    public boolean addCourse(final int i, StudentCourse course) {
        
      
    }

    public int addCourses(final int i, List<StudentCourse> courses) {
        
}

    public void printCourses() {
        for (Degree degree : degrees) {
           
    }

    public void printDegrees() {
        for (Degree degree : degrees) {
         
    }

    public void setTitleOfThesis(final int i, String title) {
             
    }


    public boolean hasGraduated() {
        
    } 

    private boolean canGraduate() {
        

    }

    public int getStudyYears() {
       
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






    
 

 