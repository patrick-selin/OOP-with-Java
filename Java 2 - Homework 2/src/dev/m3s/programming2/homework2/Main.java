package dev.m3s.programming2.homework2;

public class Main {
    public static void main(String[] args) {
    Student student1 = new Student();
    Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.0, true );
    Course course2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.0, true );
    Course course3 = new Course("More basic studies", 223344, 'a', 1, 1, 50.5, true );
    Course course4 = new Course("Even more basic studies", 556677, 'a', 0, 3, 50.0, true );
    Course course5 = new Course("Final basic studies", 123123, 'A', 1, 4, 50.5, true );
    Course course6 = new Course("Programming 2", 616161, 'A', 1, 3, 25.0, true );
    Course course7 = new Course("All kinds of master studies", 717171, 'P', 0, 2, 45.0, true );
    Course course8 = new Course("More master studies", 818181, 'A', 1, 1, 25.0, true );
    Course course9 = new Course("Even more master studies ", 919191, 'S', 1, 3, 20.0, true );
    Course course10 = new Course("Extra master studies", 666666, 'S', 0, 5, 8.0, false );
    Course course11 = new Course("Final master studies", 888888, 'S', 1, 5, 18.0, false );

// *************************************************
// *************************************************


    StudentCourse Studentcourse1 = new StudentCourse(course1, 1, 2013);

    System.out.println(Studentcourse1);
    StudentCourse Studentcourse2 = new StudentCourse(course2, 1, 2014);
    System.out.println(Studentcourse2);
    StudentCourse Studentcourse3 = new StudentCourse(course3, 1, 2015);
    System.out.println(Studentcourse3);
    StudentCourse Studentcourse4 = new StudentCourse(course4, 4, 2016);
    System.out.println(Studentcourse4);
    StudentCourse Studentcourse5 = new StudentCourse(course5, 5, 2017);
    System.out.println(Studentcourse5);
    StudentCourse Studentcourse6 = new StudentCourse(course6, 1, 2018);
    System.out.println(Studentcourse6);
    StudentCourse Studentcourse7 = new StudentCourse(course7, 1, 2019);
    System.out.println(Studentcourse7);
    StudentCourse Studentcourse8 = new StudentCourse(course8, 2, 2020);
    System.out.println(Studentcourse8);
    StudentCourse Studentcourse9 = new StudentCourse(course9, 0, 2021);
    System.out.println(Studentcourse9);
    StudentCourse Studentcourse10 = new StudentCourse(course10, 'A', 2021);
    System.out.println(Studentcourse10);
    StudentCourse Studentcourse11 = new StudentCourse(course11, 'F', 2022);
    System.out.println(Studentcourse11);

//    System.out.println(st1.isPassed());

//    Course stt = new Course();
//
//     System.out.println(Studentcourse1);










    }
}
//Course 1:
// name = "Programming 1",
// courseCode = 811104,
// courseBase = 'P',
// courseType = 1,
// period = 1,
// credits = 5.0,
// numericGrade = true
