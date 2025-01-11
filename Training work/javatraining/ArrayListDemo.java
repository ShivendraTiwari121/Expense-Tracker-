import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo {
    public static void main(String[] args){
        ArrayList<String> namelist = new ArrayList<>();
        //to add five friends name into arrayList
        namelist.add("Aditi");
        namelist.add("Aman");
        namelist.add("Adi");
        namelist.add("Aditi");
        namelist.add("Anu"); 
        //print the arraylist name using for each loop
        // for( String name : namelist){
        //     System.out.println(name);
        //}
        //to get specificvalue using index
        // System.out.println(namelist.get(namelist.size()-1));
        // //sort the arraylist
        // Collections.sort(namelist);
        // System.out.println(namelist);

        //to reverse the array 
        // for(int i = namelist.size()-1; i>=0; i--){
        //     System.out.println(namelist.get((i)));
        // }

        //duplicate of name
        int count=0;
        for(int i=0; i<namelist.size()-1; i++){
            for(int j = i+1; j<namelist.size()-1; j++){
                if( namelist.get(i).equals(namelist.get(j))){
                    count++;
            
                }
            }
        }System.out.println(count);
    }
}
