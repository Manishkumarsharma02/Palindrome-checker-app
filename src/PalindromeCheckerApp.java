
/*
UC1:Palindrome checker app
@author Manish
@version 1.0
*/
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

interface PalindromeStrategy {
    boolean checkPalindrome(String input);
    String getName();
}

// Strategy 1: Stack-based palindrome check
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String input) {
        if (input == null) return false;

        String normalized = normalize(input);
        Stack<Character> stack = new Stack<>();

        // Push all chars
        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }

        // Compare by popping
        for (int i = 0; i < normalized.length(); i++) {
            if (normalized.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "StackStrategy";
    }

    private String normalize(String s) {
        return s.toLowerCase().replaceAll("\\s+", "");
    }
}

// Strategy 2: Deque-based palindrome check (two-end comparison)
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String input) {
        if (input == null) return false;

        String normalized = normalize(input);
        Deque<Character> deque = new ArrayDeque<>();

        // Add all chars to deque
        for (int i = 0; i < normalized.length(); i++) {
            deque.addLast(normalized.charAt(i));
        }

        // Compare from both ends
        while (deque.size() > 1) {
            char left = deque.removeFirst();
            char right = deque.removeLast();
            if (left != right) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "DequeStrategy";
    }

    private String normalize(String s) {
        return s.toLowerCase().replaceAll("\\s+", "");
    }
}

// Context class: uses strategy (injected at runtime)
class PalindromeService {
    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.checkPalindrome(input);
    }

    public String currentStrategyName() {
        return strategy.getName();
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC12: Strategy Pattern Palindrome Checker ===");
        System.out.println("Choose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1/2): ");

        int choice;
        try {
            choice = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            choice = 1; // default
        }

        PalindromeStrategy selectedStrategy;
        if (choice == 2) {
            selectedStrategy = new DequeStrategy();
        } else {
            selectedStrategy = new StackStrategy();
        }

        // Inject strategy at runtime
        PalindromeService service = new PalindromeService(selectedStrategy);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        boolean result = service.check(input);

        System.out.println("Using: " + service.currentStrategyName());
        if (result) {
            System.out.println("Result: The string is a Palindrome.");
        } else {
            System.out.println("Result: The string is NOT a Palindrome.");
        }

        sc.close();
    }
}