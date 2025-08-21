package dev.m3s.programming2.homework3;

import java.time.Year;


public class DesignatedCourse {
    Course course;
    private boolean responsible;
    private int year;


    public DesignatedCourse() {
    }

    public DesignatedCourse(Course course, boolean responsible, int year) {
        setCourse(course);
        setResponsible(responsible);
        setYear(year);
    }

    public int getCurrentYear() {
        return Year.now().getValue();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if (course != null) {
            this.course = course;
        }
    }

    public boolean isResponsible() {
        return responsible;
    }

    public void setResponsible(boolean responsible) {
        this.responsible = responsible;
    }

    public boolean getResponsible() {
        return this.responsible;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 2000 &&
        year <= getCurrentYear() + 1) {
            this.year = year;
        }
    }

    @Override
    public String toString() {
        return  "[course=" + course +
                ", year=" + year +
                ']';
    }

    
}
