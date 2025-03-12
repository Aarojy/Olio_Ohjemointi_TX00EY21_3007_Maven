package Task8_2.task1;

public class PalindromeChecker {
    public static boolean isPalindrome(int number) {
        return isPalindrome(String.valueOf(number));
    }

    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }

        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }

        return isPalindrome(str.substring(1, str.length() - 1));
    }
}
