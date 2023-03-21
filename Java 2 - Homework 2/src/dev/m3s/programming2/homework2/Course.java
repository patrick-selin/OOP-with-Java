package dev.m3s.programming2.homework2;

public class Course {

    // **** ATTRIBUTES
    // ******************************
    private String name;
    private String courseCode; //e.g. 811322A
    private Character courseBase; // e.g. A
    private int courseType;
    private int period;
    private double credits;
    private boolean numericGrade;



    // **** CONSTRACTORS
    // ******************************
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
        this.courseBase = courseBase;
        setCourseType(type);
        setPeriod(period);
        setCredits(credits);
        setNumericGrade(numericGrade);

    }

    public Course( Course copy) {

        this.name = copy.name;
        this.courseCode = copy.courseCode;
        this.courseBase = copy.courseBase;
        this.courseType = copy.courseType;
        this.period = copy.period;
        this.credits = copy.credits;
        this.numericGrade = copy.numericGrade;
    }


    public void setName(String name) {
        if (name != null && !name.equals("")) {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public String getCourseTypeString() {

        if (courseType == ConstantValues.OPTIONAL) {
            return "Optional";
        } else {
            return "Mandatory";
        }
    }

    public void setCourseType(int type) {
        if (type == ConstantValues.OPTIONAL ||
            type == ConstantValues.MANDATORY) {
            this.courseType = type;
        }
    }

    public int getCourseType() {
        return courseType;
    }


    public void setCourseCode(int courseCode, Character courseBase) {
        courseBase = Character.toUpperCase(courseBase);

        if (courseCode > 0 && courseCode < 1000000) {
            if (courseBase.equals('A') ||
                courseBase.equals('P') ||
                courseBase.equals('S')) {

                this.courseBase = Character.toUpperCase(courseBase);
                this.courseCode = courseCode + String.valueOf(courseBase);
            }
        }
    }


    public String getCourseCode() {

        return courseCode.toUpperCase();
    }


    public Character getCourseBase() {
        return courseBase;
    }


    public void setPeriod(int period) {
        if (period >= ConstantValues.MIN_PERIOD &&
                period <= ConstantValues.MAX_PERIOD) {
            this.period = period;
        }
    }


    public int getPeriod() {
        return period;
    }


    private void setCredits(final double credits) {
        if (credits >= ConstantValues.MIN_CREDITS &&
           credits <= ConstantValues.MAX_COURSE_CREDITS) {
            this.credits = credits;
        }
    }

    public double getCredits() {
        return credits;
    }

    public boolean isNumericGrade() {
        return numericGrade;
    }

    public void setNumericGrade(boolean numericGrade) {
        this.numericGrade = numericGrade;
    }

    private String printCrFormat(double credits) {
        if (credits >= 10) {
            return "";
        }
        else {
            return " ";

        }
    }

    @Override
    public String toString() {
        return "[" + courseCode +
                " (" + printCrFormat(credits) + String.format("%.2f",credits) + " cr), \"" +
                name + "\". " + getCourseTypeString() + ", period: " +
                period + ".]";
    }
}
