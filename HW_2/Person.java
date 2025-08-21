package dev.m3s.programming2.homework3;

public abstract class Person {
    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private String birthDate = ConstantValues.NOT_AVAILABLE;

    public Person(String lname, String fname) {
        setLastName(lname);
        setFirstName(fname);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String setBirthDate(String personId) {
        if (personId == null) {
            return "No change";
        }
        
        PersonID testID = new PersonID();
        String isValid = testID.setPersonID(personId);

        if (isValid.equals("Ok")) {
            this.birthDate = testID.birthdateFormat(personId);
            return this.birthDate;
        }
        return "No change";
    }


    protected int getRandomId(final int min, final int max) {
        int studentId;
        studentId = (int) (Math.random() * ((max - min) + 1)) + min;

        return studentId;
    }

    abstract String getIdString();


}
