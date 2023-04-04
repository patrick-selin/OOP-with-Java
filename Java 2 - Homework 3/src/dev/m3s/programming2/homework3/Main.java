package dev.m3s.programming2.homework3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Kohta 1 : ** Create ResponsibleTeacher, set birthdate, set monthly payment


        // Kohta 2: ** Create AssistantTeacher, set birthdate, set monthly payment


        // Kohta 3: ** Create new Student object
        Student student1 = new Student("Donald", "Duck");

        // Kohta 4: ** Create 11 Courses
        Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.0, true);
        Course course2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.0, true);
        Course course3 = new Course("More basic studies", 223344, 'a', 1, 5, 50.5, true);
        Course course4 = new Course("Even more basic studies", 556677, 'a', 0, 3, 50.0, true);
        Course course5 = new Course("Final basic studies", 123123, 'A', 1, 4, 50.5, true);
        Course course6 = new Course("Programming 2", 616161, 'A', 1, 3, 25.0, true);
        Course course7 = new Course("All kinds of master studies", 717171, 'P', 0, 2, 45.0, true);
        Course course8 = new Course("More master studies", 818181, 'A', 1, 1, 25.0, true);
        Course course9 = new Course("Even more master studies ", 919191, 'S', 1, 3, 20.0, true);
        Course course10 = new Course("Extra master studies", 666666, 'S', 0, 5, 8.0, false);
        Course course11 = new Course("Final master studies", 888888, 'S', 1, 5, 18.0, false);

        // Kohta 5: ** Create DesignatedCourse

        // Kohta 6: ** Set years to DesignatedCourse

        // Kohta 7: ** Set DesignatedCourse first teacher

        // Kohta 8: ** Set DesignatedCourse first teacher

        // Kohta 9: ** Print first teacher details toString

        // Kohta 10: ** Print second teacher details toString


        // Kohta 11: ** StudentCourss for student1
        StudentCourse Studentcourse1 = new StudentCourse(course1, 1, 2013);
        StudentCourse Studentcourse2 = new StudentCourse(course2, 1, 2014);
        StudentCourse Studentcourse3 = new StudentCourse(course3, 1, 2015);
        StudentCourse Studentcourse4 = new StudentCourse(course4, 4, 2016);
        StudentCourse Studentcourse5 = new StudentCourse(course5, 5, 2017);
        StudentCourse Studentcourse6 = new StudentCourse(course6, 1, 2018);
        StudentCourse Studentcourse7 = new StudentCourse(course7, 1, 2019);
        StudentCourse Studentcourse8 = new StudentCourse(course8, 2, 2020);
        StudentCourse Studentcourse9 = new StudentCourse(course9, 0, 2021);
        StudentCourse Studentcourse10 = new StudentCourse(course10, 'A', 2021);
        StudentCourse Studentcourse11 = new StudentCourse(course11, 'F', 2022);

        // Kohta 12: ** ArrayList of Bachelor StudentCourses for student1
        ArrayList<StudentCourse> StudentBachelorCourses = new ArrayList<>();
        StudentBachelorCourses.add(Studentcourse1);
        StudentBachelorCourses.add(Studentcourse2);
        StudentBachelorCourses.add(Studentcourse3);
        StudentBachelorCourses.add(Studentcourse4);
        StudentBachelorCourses.add(Studentcourse5);

        // Kohta 13 ** ArrayList of Master StudentCourses for student1
        ArrayList<StudentCourse> StudentMasterCourses  = new ArrayList<>();
        StudentMasterCourses.add(Studentcourse6);
        StudentMasterCourses.add(Studentcourse7);
        StudentMasterCourses.add(Studentcourse8);
        StudentMasterCourses.add(Studentcourse9);
        StudentMasterCourses.add(Studentcourse10);
        StudentMasterCourses.add(Studentcourse11);

        // Kohta 14 ** Set Bachelor Degree title
        student1.setDegreeTitle(ConstantValues.BACHELOR_TYPE,
                "Bachelor of Science");

        // Kohta 15 ** Set Master Degree title
        student1.setDegreeTitle(ConstantValues.MASTER_TYPE,
                "Master of Science");

        // Kohta 16 ** Set title of Bachelor THESIS
        student1.setTitleOfThesis(1, "Bachelor thesis title");

        // Kohta 17 ** Set title of Master THESIS
        student1.setTitleOfThesis(1, "Masters thesis title");

        // Kohta 18 ** Add Bachelor courses to bachelor studies for student1
        student1.addCourses(ConstantValues.BACHELOR_TYPE, StudentBachelorCourses);

        // Kohta 19 ** Add Master courses to bachelor studies for student1
        student1.addCourses(ConstantValues.MASTER_TYPE, StudentMasterCourses);

        // Kohta 20 ** Set Start year for student1
        student1.setStartYear(2001);

        // Kohta 21 ** Set Graduation year for student1
        student1.setGraduationYear(2020);

        // Kohta 22 ** Print Student details using toString() (via Student-class)
//        System.out.println(student1.toString());

        // Kohta 23 **  Set birthdate of the student1
//        student1.setBirthdate("230498-045T");

        // Kohta 24 **  Set title of Bacherlor thesis
        // “Christmas - The most wonderful time of
        //the year”



//
////// *************************************************
////// *************************************************
////
////        System.out.println(student1);
//
//        System.out.println(student1.toString());




//        System.out.println(student1.getGraduationYear());
//        System.out.println(student1.getStartYear());

//        student1.printDegrees();
//
//        System.out.println(student1.toString());





    }
}

