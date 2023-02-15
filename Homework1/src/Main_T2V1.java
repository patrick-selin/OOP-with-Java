public class Main_T2V1 {
    public static void main(String[] args) {

        Student student1 = new Student();
        Student student2 = new Student("Mouse", "Mickey");

        student1.setFirstName("Donald");
        student1.setLastName("Duck");
        student1.setId(0);
        student1.setBachelorCredits(180);
        student1.setMasterCredits(180);
        student1.setTitleOfMastersThesis("Masters thesis title");
        student1.setTitleOfBachelorThesis("Bachelor thesis title");
        student1.setStartYear(2001);
        student1.setGraduationYear(2020);

        System.out.println(student1);
        System.out.println(student2);

    }

}