package dev.m3s.programming2.homework2;

public class Main {
    public static void main(String[] args) {

    Course kurssi1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.0, true );
    System.out.println(kurssi1);
    Course kurssi2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.0, true );
    System.out.println(kurssi2);
    Course kurssi3 = new Course("More basic studies", 223344, 'a', 1, 1, 50.5, true );
    System.out.println(kurssi3);
    Course kurssi4 = new Course("Even more basic studies", 556677, 'a', 0, 3, 50.0, true );
    System.out.println(kurssi4);
    Course kurssi5 = new Course("Final basic studies", 123123, 'A', 1, 4, 50.5, true );
    System.out.println(kurssi5);
    Course kurssi6 = new Course("Programming 2", 616161, 'A', 1, 3, 25.0, true );
    System.out.println(kurssi6);
    Course kurssi7 = new Course("All kinds of master studies", 717171, 'P', 0, 2, 45.0, true );
    System.out.println(kurssi7);
    Course kurssi8 = new Course("More master studies", 818181, 'A', 1, 1, 25.0, true );
    System.out.println(kurssi8);
    Course kurssi9 = new Course("Even more master studies ", 919191, 'S', 1, 3, 20.0, true );
    System.out.println(kurssi9);
    Course kurssi10 = new Course("Extra master studies", 666666, 'S', 0, 5, 8.0, false );
    System.out.println(kurssi10);
    Course kurssi11 = new Course("Final master studies", 888888, 'S', 1, 5, 18.0, false );
    System.out.println(kurssi11);

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
