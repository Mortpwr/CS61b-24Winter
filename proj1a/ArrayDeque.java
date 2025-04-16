public class ArrayDeque<T> {
    public int nowsize = 1;
    public int size = 8;
    public int first = 0;
    public int last = 0;
    public T[] initialarrays = (T[]) new Object[size];
    public ArrayDeque(){}
    public void resize() {
        T[] newarraylist = (T[]) new Object[size * 2];
        if (this.first != 0){
            System.arraycopy(initialarrays, this.size + this.first, newarraylist, this.size * 2 + this.first, -this.first);
        }
        System.arraycopy(initialarrays, 1, newarraylist, 1, this.last);
        this.size = size * 2;
        this.initialarrays = newarraylist;
    }
    public void addFirst(T item) {
        if(this.nowsize == this.initialarrays.length - 1) {
            this.resize();
        }
        this.first--;
        this.initialarrays[this.size + this.first] = item;
        this.nowsize++;
    }
    public void addLast(T item) {
        if(this.nowsize == this.initialarrays.length - 1) {
            this.resize();
        }
        this.last++;
        this.initialarrays[this.last] = item;
        this.nowsize++;
    }
    public boolean isEmpty() {
       return this.nowsize == 0;
    }
    public int size() {
        return this.nowsize;
    }
    public void printDeque() {
        for(int i = this.first + this.size; i < this.size; i++) {
            System.out.print(this.initialarrays[i] + " ");
        }
        for(int i = 1; i < this.last; i++) {
            System.out.print(this.initialarrays[i] + " ");
        }
    }
    public T removeFirst() {// may oversize
        T item = this.initialarrays[this.size + this.first];
        this.initialarrays[this.size + this.first] = null;
        this.first++;
        this.nowsize--;
        return item;
    }
    public T removeLast() { // may oversize
        T item = this.initialarrays[this.last];
        this.initialarrays[this.last] = null;
        this.last--;
        this.nowsize--;
        return item;
    }
    public T get(int index) {
        return this.initialarrays[this.size + this.first + index];
    }
}
