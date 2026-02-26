
/*
UC1:Palindrome checker app
@author Manish
@version 1.0
*/
import java.util.Scanner;
public class PalindromeCheckerApp {
       public static  void main(String[] args){
           System.out.println("input:");
           Scanner scanner=new Scanner(System.in);
           String name =(scanner.next());
           name= name.toLowerCase();
          boolean present =false;
           for(int i =0; i<(name.length())/2;i++){
               if(name.charAt(i)==name.charAt(name.length()-1-i)){
                   present=true;
                   break;
               }
           }
           System.out.println(name +"is it  palindrome? :"+present);
       }
}

