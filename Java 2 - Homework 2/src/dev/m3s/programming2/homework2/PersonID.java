package dev.m3s.programming2.homework2;

import java.util.HashMap;

public class PersonID {

    private String birthDate = ConstantValues.NO_BIRTHDATE;


    public PersonID() {
    }


    public String getBirthDate() {
        return this.birthDate;
    }


    public String setPersonId(final String personId) {
        if (!checkPersonIDNumber(personId)) {
            return ConstantValues.INVALID_BIRTHDAY;
        }

        String bdayFormatted = birthdayModifier(personId);

        if (!checkBirthdate(bdayFormatted )) {
            return ConstantValues.INVALID_BIRTHDAY;
        }

        if (!checkValidCharacter(personId)) {
            return ConstantValues.INCORRECT_CHECKMARK;
        }

        this.birthDate = birthdayModifier(personId);

        return "Ok";
    }


    public String birthdayModifier(final String personId) {

        String bdayModified;

        String dayStr = personId.substring(0,2);
        String monthStr = personId.substring(2,4);
        String yearStr = personId.substring(4,6);

        String century = "";

        if (personId.charAt(6) == '+') {
            century = "18";
        } else if (personId.charAt(6) == 'A') {
            century = "20";
        } else if (personId.charAt(6) == '-') {
            century = "19";
        }

        bdayModified = dayStr + "." + monthStr
                + "." + century + yearStr;

        return bdayModified;
    }


    private boolean checkPersonIDNumber(final String personId) {
        return personId.length() == 11&& (
                personId.charAt(6) == '-' ||
                        personId.charAt(6) == '+' ||
                        personId.charAt(6) == 'A');
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
        boolean isValidDate = true;

        if (date.length() != 10) {
            return false;
        }

        String dayStr = date.substring(0,2);
        int dayNum = Integer.parseInt(dayStr);

        String monthStr = date.substring(3,5);
        int monthNum = Integer.parseInt(monthStr);

        String yearStr = date.substring(6,10);
        int yearNum = Integer.parseInt(yearStr);

        if (yearNum < 0 || monthNum < 1 || monthNum > 12 ||
                dayNum < 1 || dayNum > 31) {
            isValidDate = false;
        }
        else {
            switch (monthNum) {
                case 4, 6, 9, 11 -> {
                    if (dayNum == 31)
                        isValidDate = false;
                }
                case 2 -> {
                    if (dayNum > 29)
                        isValidDate = false;
                    if (dayNum == 29)
                        isValidDate = checkLeapYear(yearNum);
                }
            }
        }
        return isValidDate;
    }







}
