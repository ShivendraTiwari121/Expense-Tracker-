import java.util.*;
public class ClassObjects {
    public static void main(String[] args){

        Student student = new Student();
        student.setStudentName("Aditi Tiwari");
        student.setStudentTechnology("java");
        System.out.println(student.getStudentName()+ student.getStudentTechnology);
    
    // Trainer trainer = new Trainer();
    // System.out.println("Enter the trainer name");
    Scanner sc = new Scanner(System.in);
    // trainer.trainerName = scanner.nextLine();
    // System.out.println("Enter the trainer technology");
    // System.out.println(trainer.trainername + trainer.trainerTechnology);
    String first=sc.nextLine();
    String last=sc.nextLine();
    System.out.println(ConcatName(first,last));
    sc.close();
    
    }



static String ConcatName(String fname, String lname){
    
    String name = lname.concat(fname);
    return name;
}

class Student{
    String studentName;
    String studentTechnology;
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentTechnology() {
        return studentTechnology;
    }
    public void setStudentTechnology(String studentTechnology) {
        this.studentTechnology = studentTechnology;
    }
}
}

String nameConcatString(String fname, String mname, String lname){
    return fname + mname + lname ;
}