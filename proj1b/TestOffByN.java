import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static OffByN offByN = new OffByN(4);
    static OffByN offByN2 = new OffByN(5);
    static Palindrome palindrome = new Palindrome();

    @Test
    public void test1() {
        assertTrue(palindrome.isPalindrome("a", offByN));
    }
    @Test
    public void test2() {
        assertTrue(palindrome.isPalindrome("a", offByN2));
    }
}
