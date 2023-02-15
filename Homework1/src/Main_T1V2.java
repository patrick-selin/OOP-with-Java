public class Main_T1V2 {
    public static void main(String[] args) {

        Student student1 = new Student();
        Student student2 = new Student("Mouse", "Mickey");
        Student student3 = new Student("Mouse", "Minnie");

        student1.setFirstName("Donald");
        student1.setLastName("Duck");
        student1.setBachelorCredits(120);
        student1.setMasterCredits(180);
        student1.setTitleOfMastersThesis("Masters thesis title");
        student1.setTitleOfBachelorThesis("Bachelor thesis title");
        student1.setStartYear(2001);
        student1.setGraduationYear(2020);

        // student2.setPersonId("221199-123A");
        student2.setTitleOfBachelorThesis("A new exciting purpose of life");
        student2.setBachelorCredits(65);
        student2.setMasterCredits(22);

        // student3.setPersonId("111111-334");
        student3.setBachelorCredits(215);
        student3.setMasterCredits(120);
        student3.setTitleOfBachelorThesis("Dreaming of a white Christmas");
        student3.setTitleOfMastersThesis("Christmas - The most wonderful time of the year");
        student3.setStartYear(2018);
        student3.setGraduationYear(2022);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

        // Print the output when setting the person id “This is a string”
        // Print the output when setting the person id “320187-1234”
        // Print the output when setting the person id ““11111111-3334”
        // Print the output when setting the person id “121298-830A”



    }

}