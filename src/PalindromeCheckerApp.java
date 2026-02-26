
/*
UC1:Palindrome checker app
@author Manish
@version 1.0
*/
import javax.xml.namespace.QName;
import java.util.Stack;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String name = "noon";
        Stack<Character> stack = new Stack<>();
        for (char c : name.toCharArray()) {
            stack.push(c);
        }
        boolean ispalindrome = true;
        for (char c : name.toCharArray()) {
            if (c != stack.pop()) {
                ispalindrome = false;
                break;
            }
        }

        System.out.println("input text : " + name);
        System.out.print("Is it a Palindrome? : " + ispalindrome);
    }
}