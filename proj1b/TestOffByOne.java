import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne extends TestPalindrome {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    // Your tests go here.
    @Test
    public void testOffByOne() {
        assertTrue(palindrome.isPalindrome("flake", offByOne));
    }
    @Test
    public void testOffByOne2() {
        assertTrue(palindrome.isPalindrome("acbb", offByOne));
    }
    @Test
    public void testOffByOne3() {
        assertTrue(palindrome.isPalindrome("", offByOne));
    }
    @Test
    public void testOffByOne4() {
        assertTrue(palindrome.isPalindrome("a", offByOne));
    }
    @Test
    public void testOffByOne5() {
        assertTrue(palindrome.isPalindrome("ab", offByOne));
        assertTrue(palindrome.isPalindrome("ba", offByOne));
        assertFalse(palindrome.isPalindrome("Ab", offByOne));
        assertFalse(palindrome.isPalindrome("Ba", offByOne));
    }
    @Test
    public void testOffByOne6() {
        assertTrue(palindrome.isPalindrome("%&", offByOne));
        assertFalse(palindrome.isPalindrome("<>", offByOne));
    }
}
