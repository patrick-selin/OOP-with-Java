package dev.m3s.programming2.homework3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Kohta 1: ** Create new Student object
        Student student1 = new Student();

        // Kohta 2: ** Create 11 Courses
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

        // Kohta 3: ** StudentCourss for student1
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

        // Kohta 4: ** Array of Bachelor StudentCourses for student1
        StudentCourse[] StudentBachelorCourses = new StudentCourse[50];
        StudentBachelorCourses[0] = Studentcourse1;
        StudentBachelorCourses[1] = Studentcourse2;
        StudentBachelorCourses[2] = Studentcourse3;
        StudentBachelorCourses[3] = Studentcourse4;
        StudentBachelorCourses[4] = Studentcourse5;

        // Kohta 5 ** Array of Master StudentCourses for student1
        StudentCourse[] StudentMasterCourses = new StudentCourse[50];
        StudentMasterCourses[5] = Studentcourse6;
        StudentMasterCourses[6] = Studentcourse7;
        StudentMasterCourses[7] = Studentcourse8;
        StudentMasterCourses[8] = Studentcourse9;
        StudentMasterCourses[9] = Studentcourse10;
        StudentMasterCourses[10] = Studentcourse11;

        // Kohta 6 ** Set Bachelor Degree title
        student1.setDegreeTitle(ConstantValues.BACHELOR_TYPE,
                "Bachelor of Science");

        // Kohta 7 ** Set Master Degree title
        student1.setDegreeTitle(ConstantValues.MASTER_TYPE,
                "Master of Science");

        // Kohta 8 ** Set title of Bachelor THESIS
        student1.setTitleOfThesis(0, "Bachelor thesis title");

        // Kohta 9 ** Set title of Master THESIS
        student1.setTitleOfThesis(1, "Masters thesis title");

        // Kohta 10 ** Add Bachelor courses to bachelor studies for student1
        student1.addCourses(ConstantValues.BACHELOR_TYPE, StudentBachelorCourses);
//
        // Kohta 11 ** Add Master courses to bachelor studies for student1
        student1.addCourses(ConstantValues.MASTER_TYPE, StudentMasterCourses);

        // Kohta 12 ** Set Start year for student1
        student1.setStartYear(2001);

        // Kohta 13 ** Set Graduation year for student1
        student1.setGraduationYear(2020);

        // Kohta 14 ** Set First name for student1
        student1.setFirstName("Donald");

        // Kohta 15 ** Set Last name for student1
        student1.setLastName("Duck");

        // Kohta 16 ** Print Student details using toString() (via Student-class)
//        System.out.println(student1.toString());

        // Kohta 17 **  Set birthdate of the student1
        student1.setBirthdate("230498-045T");

//// *************************************************
//// *************************************************
//
        System.out.println(student1);




    }
}

