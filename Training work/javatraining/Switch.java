import java.util.*;
public class Switch {
   public static void main(String[] args){
    Scanner sc =  new Scanner(System.in);
    System.out.println("Enter Marks of student ");
    int n = sc.nextInt();
    switch (n) {
        case 10:{
            System.out.println(" E");
        }
            
            break;
          case 50 :{
            System.out.println("Pass D");
          } break;
          case 80:{
            System.out.println("Pass B");
          }break;
          case 90:
          {
            System.out.println("Pass A");
          } break;
    
        default:{
            System.out.println("Marks not found ");
        }
            break;
    }
   } 
}
