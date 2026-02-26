
/*
UC1:Palindrome checker app
@author Manish
@version 1.0
*/
import  java.util.Scanner;

public class PalindromeCheckerApp {
       public static  void main(String[] args){
           System.out.println("input:");
           Scanner scanner=new Scanner(System.in);
           String original =(scanner.next());
           String Reverse ="";
           boolean present=false;
           for (int i=original.length()-1;i>=0;i--){
               Reverse=Reverse+original.charAt(i);
           }
           for (int i=0;i<original.length();i++){
               if(original.charAt(i)==Reverse.charAt(i)){
                   present=true;
               }else {
                   present=false;
               }
           }
           if(present==true){
               System.out.println(original+" and "+Reverse+" are Palindrome");
           }else{
               System.out.println(original+" and "+Reverse+" are not  Palindrome");
           }



       }
}

