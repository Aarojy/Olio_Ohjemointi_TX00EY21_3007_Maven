package Task8_2.task1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    @Test
    void testNumberTrue() {
        assertTrue(PalindromeChecker.isPalindrome(12321));
        assertTrue(PalindromeChecker.isPalindrome(1234554321));
    }

    @Test
    void testNumberFalse() {
        assertFalse(PalindromeChecker.isPalindrome(12345));
        assertFalse(PalindromeChecker.isPalindrome(123455432));
    }

    @Test
    void testSingleDigit() {
        assertTrue(PalindromeChecker.isPalindrome(1));
    }


    @Test
    void testStringTrue() {
        assertTrue(PalindromeChecker.isPalindrome("asdfghjkjhgfdsa"));
        assertTrue(PalindromeChecker.isPalindrome("racecar"));
    }

    @Test
    void testStringFalse() {
        assertFalse(PalindromeChecker.isPalindrome("asdfghjkl"));
        assertFalse(PalindromeChecker.isPalindrome("mall"));
    }

    @Test
    void testEmptyString() {
        assertTrue(PalindromeChecker.isPalindrome(""));
    }

    @Test
    void testSingleChar() {
        assertTrue(PalindromeChecker.isPalindrome("a"));
    }
}