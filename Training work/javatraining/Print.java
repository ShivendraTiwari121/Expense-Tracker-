import java.util.Scanner;
public class Print {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter age");
        int age = sc.nextInt();
        System.out.println("Age is"+age);
        String output = age>18?"eligible":"not eligible";
        System.out.println(output);
    }
}