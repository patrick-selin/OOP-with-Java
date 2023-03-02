public class Main_T3V1 {
    public static void main(String[] args) {

        Student student1 = new Student();
        Student student2 = new Student("Mouse", "Mickey");
        Student student3 = new Student("Mouse", "Minnie");

        student1.setFirstName("Donald");
        student1.setLastName("Duck");
        student1.setId(0);
        student1.setBachelorCredits(120);
        student1.setMasterCredits(180);
        student1.setTitleOfBachelorThesis("Bachelor thesis title");
        student1.setStartYear(2001);
        student1.setGraduationYear(2020);


//        student2.setPersonId("220999-1559" );

        student2.setBachelorCredits(65);
        student2.setMasterCredits(22);
        student2.setTitleOfBachelorThesis("A new exciting purpose of life");

        student3.setBachelorCredits(215);
        student3.setMasterCredits(120);
        student3.setTitleOfMastersThesis("Christmas - The most wonderful time of the year");
        student3.setTitleOfBachelorThesis("Dreaming of a white Christmas");
        student3.setStartYear(2018);
        student3.setGraduationYear(2022);

        System.out.println(student2);








    }

}