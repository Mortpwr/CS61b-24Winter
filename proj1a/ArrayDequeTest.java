public class ArrayDequeTest {
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("expected: " + expected + ", actual: " + actual);
            return expected;
        } else {
            return true;
        }
    }

    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("expected: " + expected + ", actual: " + actual);
            return false;
        } else {
            return true;
        }
    }

    public static void addTest(int index) {
        ArrayDeque newarray = new ArrayDeque();
        for (int i = 0; i < index; i++) {
            newarray.addLast(i);
        }
        for (int i = 0; i < index; i++) {
            newarray.addFirst(i);
        }
        newarray.printDeque();
        checkSize(index, newarray.size());
    }

    public static void removeTest(int index) {
        ArrayDeque newarray = new ArrayDeque();
        ArrayDeque newarray2 = new ArrayDeque();
        for (int i = 0; i < index; i++) {
            newarray.addLast(i);
        }
        newarray.removeFirst();
        newarray.removeLast();
        newarray.printDeque();
        newarray2.removeFirst();
        newarray2.printDeque();
    }

    public static void main(String[] args) {
        removeTest(128);
    }
}
