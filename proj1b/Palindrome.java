import java.util.ArrayDeque;
import java.util.LinkedList;

public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> deque = new LinkedListDeque<>();
        for(char c : word.toCharArray()){
            Character temp = c;
            deque.addLast(temp);
        }
        return deque;
    }

    public boolean isPalindrome(String word){
        Deque<Character> deque = wordToDeque(word);
        while(deque.size() > 1){
            if(!deque.removeFirst().equals(deque.removeLast())){
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> deque = wordToDeque(word);
        while(deque.size() > 1){
            if(!cc.equalChars(deque.removeFirst(), deque.removeLast())){
                return false;
            }
        }
        return true;
    }
}
