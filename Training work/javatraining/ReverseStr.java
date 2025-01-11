import java.util.Scanner;
public class ReverseStr {
    public static void main(String[] args){
    String ch = "";
    System.out.println("Enter your string");
     Scanner sc = new Scanner(System.in);
     String str = sc.nextLine();
     for(int i = str.length()-1; i >= 0; i--){
       ch += str.charAt(i);
     }
     System.out.println("Reverse String is" + ch.trim());
     sc.close();
    }
}
