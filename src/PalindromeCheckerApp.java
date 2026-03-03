
/*
UC1:Palindrome checker app
@author Manish
@version 1.0
*/
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    // -------------------- Normalization --------------------
    // Common preprocessing so all algorithms compare fairly
    static String normalize(String s) {
        if (s == null) return "";
        // lower case + remove spaces
        return s.toLowerCase().replaceAll("\\s+", "");
    }

    // -------------------- Algorithm 1: Two-Pointer (Array) --------------------
    static boolean palindromeTwoPointer(String input) {
        String s = normalize(input);
        char[] arr = s.toCharArray();

        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    // -------------------- Algorithm 2: Recursion --------------------
    static boolean palindromeRecursion(String input) {
        String s = normalize(input);
        return recCheck(s, 0, s.length() - 1);
    }

    static boolean recCheck(String s, int start, int end) {
        if (start >= end) return true;                 // base condition
        if (s.charAt(start) != s.charAt(end)) return false;
        return recCheck(s, start + 1, end - 1);
    }

    // -------------------- Algorithm 3: Stack --------------------
    static boolean palindromeStack(String input) {
        String s = normalize(input);
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) stack.push(s.charAt(i));
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != stack.pop()) return false;
        }
        return true;
    }

    // -------------------- Algorithm 4: Deque --------------------
    static boolean palindromeDeque(String input) {
        String s = normalize(input);
        Deque<Character> dq = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) dq.addLast(s.charAt(i));

        while (dq.size() > 1) {
            if (dq.removeFirst() != dq.removeLast()) return false;
        }
        return true;
    }

    // -------------------- Timing Utility --------------------
    static long timeAlgo(Runnable r) {
        long start = System.nanoTime();
        r.run();
        long end = System.nanoTime();
        return end - start;
    }

    // Optional: run each algorithm multiple times to reduce noise
    static long timeAlgoMultipleRuns(Runnable r, int runs) {
        long start = System.nanoTime();
        for (int i = 0; i < runs; i++) r.run();
        long end = System.nanoTime();
        return (end - start) / runs; // average per run
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC13: Palindrome Performance Comparison ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // To make timing more stable, we measure average over multiple runs
        int runs = 1000;

        // Run once for correctness check (all should match)
        boolean res1 = palindromeTwoPointer(input);
        boolean res2 = palindromeRecursion(input);
        boolean res3 = palindromeStack(input);
        boolean res4 = palindromeDeque(input);

        // If any mismatch (rare), show warning
        if (!(res1 == res2 && res2 == res3 && res3 == res4)) {
            System.out.println("Warning: Algorithms returned different results!");
        }

        // Measure timing (average nanoseconds)
        long t1 = timeAlgoMultipleRuns(() -> palindromeTwoPointer(input), runs);
        long t2 = timeAlgoMultipleRuns(() -> palindromeRecursion(input), runs);
        long t3 = timeAlgoMultipleRuns(() -> palindromeStack(input), runs);
        long t4 = timeAlgoMultipleRuns(() -> palindromeDeque(input), runs);

        System.out.println("\nResult (all algorithms): " + (res1 ? "PALINDROME" : "NOT PALINDROME"));
        System.out.println("Timing shown as average per run over " + runs + " runs.\n");

        // Display results
        System.out.println("+---------------------------+---------------+");
        System.out.println("| Algorithm                 | Time (ns)     |");
        System.out.println("+---------------------------+---------------+");
        System.out.printf("| %-25s | %-13d |\n", "Two-Pointer (Array)", t1);
        System.out.printf("| %-25s | %-13d |\n", "Recursion (Call Stack)", t2);
        System.out.printf("| %-25s | %-13d |\n", "Stack Strategy", t3);
        System.out.printf("| %-25s | %-13d |\n", "Deque Strategy", t4);
        System.out.println("+---------------------------+---------------+");

        sc.close();
    }
}