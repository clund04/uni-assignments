package dev.m3s.programming2.homework3;

public class Course {
    private String name = ConstantValues.NO_TITLE;
    private String courseCode = ConstantValues.NOT_AVAILABLE;
    private Character courseBase = ' ';
    private int courseType;
    private int period;
    private double credits;
    private boolean numericGrade;


    public Course() {   
    }

    public Course(String name,
                  final int code,
                  Character courseBase,
                  final int type,
                  final int period,
                  final double credits,
                  boolean numericGrade) {
        setName(name);
        setCourseCode(code, courseBase);
        setCourseType(type);
        setPeriod(period);
        setCredits(credits);
    }

    public Course(Course course) {
        if (course != null) {
            this.name = course.name;
            this.courseCode = course.courseCode;
            this.courseBase = course.courseBase;
            this.courseType = course.courseType;
            this.period = course.period;
            this.credits = course.credits;
            this.numericGrade = course.numericGrade;
        }    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("") && name != null) {
            this.name = name;
        }
    }

    public String getCourseTypeString() {
        if (courseType == ConstantValues.OPTIONAL) {
            return "Optional";
        } else if (courseType == ConstantValues.MANDATORY) {
            return "Mandatory";
        }
        return "Unknown";
    }

    public int getCourseType() {
        return courseType;
    }

    public void setCourseType(final int type) {
        if (type == ConstantValues.OPTIONAL ||
             type == ConstantValues.MANDATORY) {
                this.courseType = type;
        }
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(final int courseCode, Character courseBase) {
        courseBase = Character.toUpperCase(courseBase);

        if (courseCode > 0 && courseCode < 1000000) {
            if (courseBase =='A' ||
            courseBase == 'P' ||
            courseBase == 'S') {

                this.courseBase = courseBase;
                this.courseCode = courseCode + "" + courseBase;
            }
        }
    }

    public Character getCourseBase() {
        return courseBase;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        if (ConstantValues.MIN_PERIOD <= period && 
            ConstantValues.MAX_PERIOD >= period) {
            this.period = period;
        }

    }

    public double getCredits() {
        return credits;
    }

    private void setCredits(final double credits) {
        if (ConstantValues.MIN_CREDITS <= credits &&
            credits <= ConstantValues.MAX_COURSE_CREDITS){
            this.credits = credits;

        }
    }

    boolean isNumericGrade() {
        return numericGrade;
    }

    private void setNumericGrade(boolean numericGrade) {
        this.numericGrade = numericGrade;
    }

    @Override
    public String toString() {
        String courseName = (name != null) ? "\"" + name + "\"" : "null";
        
        return "[" + courseCode +
               " (" + String.format("%.2f", credits) + " cr), " +
               courseName + ". " + getCourseTypeString() +
               ", period: " + period + ".]";
    }
}