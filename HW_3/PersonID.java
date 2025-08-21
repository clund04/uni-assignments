package dev.m3s.programming2.homework3;

import java.util.HashMap;

public class PersonID {

    private String birthDate = ConstantValues.NO_BIRTHDATE;

    public PersonID() {
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public String setPersonID(final String personID) {
        if (personID == null) {
            return ConstantValues.INVALID_BIRTHDAY;
        }

        if (!checkPersonIDNumber(personID)) {
            return ConstantValues.INVALID_BIRTHDAY;
        }

        String birthdateFormatted = birthdateFormat(personID);
        if (!checkBirthdate(birthdateFormatted)) {
            return ConstantValues.INVALID_BIRTHDAY;
        }

        if (!checkValidCharacter(personID)) {
            return ConstantValues.INCORRECT_CHECKMARK;
        }

        this.birthDate = birthdateFormat(personID);
        return "Ok";
    }

    public String birthdateFormat(final String personID) {
        String day = personID.substring(0,2);
        String month = personID.substring(2,4);
        String year = personID.substring(4,6);
        String century = "";

        if (personID.charAt(6) == '+') {
            century = "18";
        } else if (personID.charAt(6) == '-') {
            century = "19";
        } else if (personID.charAt(6) == 'A') {
            century = "20";
        }
        return day + "." + month + "." + century + year;

    }

    private boolean checkPersonIDNumber(final String personID) {
        if (personID.length() != 11) {
            return false;
        }
        return personID.charAt(6) == '-' ||
        personID.charAt(6) == '+' || 
        personID.charAt(6) == 'A'; 

    }

    private boolean checkLeapYear(int year) {
        boolean isLeapYear;
        isLeapYear = (year % 4 == 0);
        isLeapYear = isLeapYear &&
                     (year % 100 != 0 ||
                     year % 400 == 0);
        return isLeapYear;

    }

    private boolean checkValidCharacter(final String personID) {
        boolean isValidChar = false;

        String firstNumStr = personID.substring(0,6);
        String secondNumStr = personID.substring(7,10);

        String wholeNumberStr = firstNumStr +secondNumStr;
        double wholeNumber = Integer.parseInt(wholeNumberStr);

        double sum = ((wholeNumber / 31) % 1) * 31;
        int sum4 = (int) Math.round(sum);

        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("A", (10)); hm.put("B", (11)); hm.put("C", (12));
        hm.put("D", (13)); hm.put("E", (14)); hm.put("F", (15));
        hm.put("H", (16)); hm.put("J", (17)); hm.put("K", (18));
        hm.put("L", (19)); hm.put("M", (20)); hm.put("N", (21));
        hm.put("P", (22)); hm.put("R", (23)); hm.put("S", (24));
        hm.put("T", (25)); hm.put("U", (26)); hm.put("V", (27));
        hm.put("W", (28)); hm.put("X", (29)); hm.put("Y", (30));

        hm.put("0", (0)); hm.put("1", (1)); hm.put("2", (2));
        hm.put("3", (3)); hm.put("4", (4)); hm.put("5", (5));
        hm.put("6", (6)); hm.put("7", (7)); hm.put("8", (8));
        hm.put("9", (9));

        String lastChar = personID.substring(10,11); // R

        if (hm.containsKey(lastChar)) {
            int value = hm.get(lastChar);

            if (value== sum4) {
                isValidChar = true;
            }
        }

        return isValidChar;
    }

    private boolean checkBirthdate(final String date) {
        if (date.length() != 10 || date == null) {
            return false;
        }

        try {
            int day = Integer.parseInt(date.substring(0, 2));
            int month = Integer.parseInt(date.substring(3, 5));
            int year = Integer.parseInt(date.substring(6, 10));

            if (year < 0 || month < 1 || month > 12 || day < 1 || day > 31) {
                return false;
            } 

            return day <= switch (month) {
                case 4, 6, 9, 11 -> 30;
                case 2 -> (checkLeapYear(year) ? 29 : 28);
                default -> 31;
            };
        } catch (NumberFormatException e) {
                return false;
            }
        }

    }


    
