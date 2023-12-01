import java.util.Scanner;

public class palindrome{

    public static boolean isPalindrome(String word) {
        // Remove spaces and convert the word to lowercase
        word = word.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word to check if it's a palindrome: ");
        String userWord = scanner.nextLine();

        // Check if the entered word is a palindrome or not
        if (isPalindrome(userWord)) {
            System.out.println("YES, IT IS PALINDROME");
        } else {
            System.out.println("NO, IT IS NOT A PALINDROME");
        }

        scanner.close();
    }
}