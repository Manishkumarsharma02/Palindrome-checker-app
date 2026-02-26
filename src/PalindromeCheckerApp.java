
/*
UC1:Palindrome checker app
@author Manish
@version 1.0
*/

public class PalindromeCheckerApp {
    public static void main(String[] args){
        String name="radar";
        char[] chars = name.toCharArray();
        int start=0;
        int end= chars.length-1;
        boolean isPalindrome=true;
        while(start<end){
            if(chars[start] != chars[end]){
                isPalindrome=false;
                break;
            }
            start++;
            end--;
        }
        System.out.println("input text : "+name);
        System.out.print("Is it a Palindrome? : "+isPalindrome);
    }
}

