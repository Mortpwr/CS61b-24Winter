public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char ch1, char ch2) {
        return Math.abs(ch1 - ch2) == 1;
    }
}
