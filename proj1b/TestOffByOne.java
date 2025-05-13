import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne extends TestPalindrome{

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
        assertTrue(palindrome.isPalindrome("f", offByOne));
    }
    @Test
    public void testOffByOne3() {
        assertTrue(palindrome.isPalindrome("", offByOne));
    }
}
