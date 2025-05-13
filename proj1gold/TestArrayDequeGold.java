import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayDeque;

public class TestArrayDequeGold {
    @Test
    public void Test(){
        StudentArrayDeque<Integer> StudentDeque = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> SolutionDeque = new ArrayDequeSolution<Integer>();
        String StringStudent = "";
        for (int i = 0; i < 20; i++) {
            double rand = Math.random();
            if (rand < 0.5) {
                StudentDeque.addLast(i);
                SolutionDeque.addLast(i);
                StringStudent = StringStudent + "addLast(" + i + ")\n";
            }
            else {
                StudentDeque.addFirst(i);
                SolutionDeque.addFirst(i);
                StringStudent = StringStudent + "addFirst(" + i + ")\n";
            }
        }
        for (int i = 0; i < 20; i++) {
            double rand = Math.random();
            Integer Student;
            Integer Solution;
            if (rand < 0.5) {
                Student = StudentDeque.removeFirst();
                Solution = SolutionDeque.removeFirst();
                StringStudent = StringStudent + "removeFirst()\n";
                assertEquals(StringStudent, Student, Solution);
            }
            else {
                Student = StudentDeque.removeLast();
                Solution = SolutionDeque.removeLast();
                StringStudent = StringStudent + "removeLast()\n";
                assertEquals(StringStudent, Student, Solution);
            }
        }
    }
}

