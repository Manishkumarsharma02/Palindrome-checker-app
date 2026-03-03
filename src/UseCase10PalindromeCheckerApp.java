
/*
UC1:Palindrome checker app
@author Manish
@version 1.0
*/
import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    // Method to normalize string
    public static String normalize(String str) {

        // Convert to lowercase
        str = str.toLowerCase();

        // Remove spaces using regular expression
        str = str.replaceAll("\\s+", "");

        return str;
    }

    // Method to check palindrome (iterative approach)
    public static boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Case-Insensitive & Space-Ignored Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Step 1: Normalize string
        String processed = normalize(input);

        // Step 2: Apply palindrome logic
        if (isPalindrome(processed)) {
            System.out.println("Result: The string is a Palindrome.");
        } else {
            System.out.println("Result: The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}