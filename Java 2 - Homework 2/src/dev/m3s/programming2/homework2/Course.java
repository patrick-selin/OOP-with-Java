package dev.m3s.programming2.homework2;

public class Course {

    // **** ATTRIBUTES
    // ******************************
    private String name;
    private String courseCode;
    private Character courseBase;
    private int courseType;
    private int period;
    private double credits;
    private boolean numericGrade;



    // **** CONSTRACTORS
    // ******************************
    public Course() {
    }

    public Course(String name,
                  final int courseCode,
                  Character courseBase,
                  final int courseType,
                  final int period,
                  final double credits,
                  boolean numericGrade) {

        setName(name);
        setCourseCode(courseCode, courseBase); // 811322A
        this.courseBase = courseBase; // A, P, S
        setCourseType(courseType); // 0 tai 1
        setPeriod(period);
        setCredits(credits);
        setNumericGrade(numericGrade);

    }

    public Course(Course course) {

    }

// ***********TÄÄ PUUTTUU VIELÄ

//    public Course(Course course) {
//        // tämä saa siis Course-olion parametrina mutta en vielä
          // taju mitä tällä tehdään. Voi olla et liittyy muihi luokkiin?
//    }


    // **** METHODIT
    // ******************************

    public void setName(String name) {
        if (name != null) {
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
        if (courseCode > 0 && courseCode < 1000000) {
            if (courseBase.equals('A') ||
                courseBase.equals('P') ||
                courseBase.equals('S')) {

                this.courseCode = String.valueOf(courseCode) + String.valueOf(courseBase);
            }
        }
    }

    public String getCourseCode() {
        return courseCode;
    }

    public Character getCourseBase() {
        return this.courseBase;
    }

    public void setPeriod(int period) {
        if (period >= ConstantValues.MIN_PERIOD &&
                period <= ConstantValues.MAX_PERIOD) {
            this.period = period;
        }
    }

    public int getPeriod() {
        return this.period;
    }


    // muista laittaa PRIVATE
    public void setCredits(final double credits) {
        if (credits >= ConstantValues.MIN_CREDITS &&
           credits <= ConstantValues.MAX_CREDITS) {
            this.credits = credits;
        }
    }

    public double getCredits() {
        return this.credits;
    }

    public boolean isNumericGrade() {
        return numericGrade;
    }

    public void setNumericGrade(boolean numericGrade) {
        this.numericGrade = numericGrade;
    }

    @Override
    public String toString() {
        return "[" + courseCode + " (" + credits + " cr), \"" +
                name + "\". " + getCourseTypeString() + ", period: " + period + ".]";
    }
}
