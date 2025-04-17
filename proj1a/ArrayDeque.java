public class ArrayDeque<T> {
    private int nowsize = 0;
    private int size = 8;
    private int first = 0;
    private int last = 0;
    private T[] initialarrays = (T[]) new Object[size];
    public ArrayDeque(){}
    private void resize() {
        int dsize = this.size * 2;
        T[] newarraylist = (T[]) new Object[dsize];
        for(int i = 0; i < this.nowsize; i++){
            newarraylist[(this.first + i) % dsize] = this.initialarrays[(first + i) % this.size];
        }
    }
    public void addFirst(T item) {
        if(this.nowsize == this.size) {
            this.resize();
        }
        this.first--;
        this.initialarrays[this.first % this.size] = item;
        this.nowsize++;
    }
    public void addLast(T item) {
        if(this.nowsize == this.size) {
            this.resize();
        }
        this.last++;
        this.initialarrays[this.last % this.size] = item;
        this.nowsize++;
    }
    public boolean isEmpty() {
       return this.nowsize == 0;
    }
    public int size() {
        return this.nowsize;
    }
    public void printDeque() {
        for(int i = 0; i < this.nowsize; i++) {
            System.out.print(this.initialarrays[(this.first + i) % this.size] + " ");
        }
    }
    private boolean pointerHelper(){
       return this.first >= this.last;
    }
    public T removeFirst() {// may oversize
        if(this.pointerHelper()) {
            return null;
        }
        else{
            T item = this.initialarrays[this.first % this.size];
            this.initialarrays[this.first % size] = null;
            this.first++;
            this.nowsize--;
            return item;
        }
    }
    public T removeLast() { // may oversize
       if(this.pointerHelper()) {
           return null;
       }
       else{
            T item = this.initialarrays[this.last % this.size];
            this.initialarrays[this.last % this.size] = null;
            this.last--;
            this.nowsize--;
            return item;
       }
    }
    public T get(int index) {
        return this.initialarrays[(this.first + index) % this.size];
    }
}
