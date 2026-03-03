
/*
UC1:Palindrome checker app
@author Manish
@version 1.0
*/
import java.util.Scanner;

class PalindromeChecker {

    // Encapsulated method: does all palindrome work internally
    public boolean checkPalindrome(String input) {

        if (input == null) return false;

        // Preprocess: ignore spaces + case (common requirement)
        String normalized = normalize(input);

        // Internal data structure: Array (char array)
        char[] arr = normalized.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Private helper (encapsulation): not visible outside the class
    private String normalize(String str) {
        // Lowercase + remove spaces
        return str.toLowerCase().replaceAll("\\s+", "");
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC11: Object-Oriented Palindrome Service ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Create service object
        PalindromeChecker checker = new PalindromeChecker();

        // Call the service method
        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("Result: The string is a Palindrome.");
        } else {
            System.out.println("Result: The string is NOT a Palindrome.");
        }

        sc.close();
    }
}