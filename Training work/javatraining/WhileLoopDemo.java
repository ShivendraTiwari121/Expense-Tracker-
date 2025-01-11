public class WhileLoopDemo{
    public static void main(String[] args){
        int i  = 1;
        int sum=0;
        while(i <= 10){
            sum  = sum + i;
            System.out.println(i);
            i++;
        }
        
        System.out.println(sum);
    }
}
