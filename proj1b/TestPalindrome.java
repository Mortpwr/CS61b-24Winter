import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testisPalindrome() {
        assertTrue(palindrome.isPalindrome("abba"));
    }
    @Test
    public void testisPalindrome2() {
        assertTrue(palindrome.isPalindrome("a"));
    }
    @Test
    public void testisPalindrome3() {
        assertTrue(palindrome.isPalindrome(""));
    }
    @Test
    public void testisPalindrome4() {
        assertTrue(palindrome.isPalindrome("ABCCBA"));
    }
    @Test
    public void testisPalindrome5() {
        assertFalse(palindrome.isPalindrome("DdDdDd"));
        assertFalse(palindrome.isPalindrome("<><>"));
        assertTrue(palindrome.isPalindrome("$<<<<<<$"));
        assertFalse(palindrome.isPalindrome("Aa"));
        assertFalse(palindrome.isPalindrome("aA"));
    }

}
