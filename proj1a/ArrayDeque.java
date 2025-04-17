public class ArrayDeque<T> {
    private int nowsize = 0;
    private int size = 8;
    private int first = 0;
    private int last = 0;
    private T[] initialarrays = (T[]) new Object[this.size];

    public ArrayDeque() {
    }
    private int posModular(int dividend, int divisor) {
        return (divisor % dividend + dividend) % dividend;
    }
    private void resize() {
        int dsize = this.size * 2;
        T[] newarraylist = (T[]) new Object[dsize];
        for (int i = 0; i < this.nowsize; i++) {
            newarraylist[posModular(dsize, first + i)] = this.initialarrays[posModular(this.size, first + i)];
        }
        this.size = dsize;
        this.initialarrays = newarraylist;
    }

    public void addFirst(T item) {
        if (this.nowsize == this.size) {
            this.resize();
        }
        if (!(this.first == this.last) || !(this.nowsize == 0)) {
            this.first--;
        }
        this.nowsize++;
        this.initialarrays[posModular(this.size, this.first)] = item;

    }

    public void addLast(T item) {
        if (this.nowsize == this.size) {
            this.resize();
        }
        if (!(this.first == this.last) || !(this.nowsize == 0)) {
            this.last++;
        }
        this.nowsize++;
        this.initialarrays[posModular(this.size, this.last)] = item;
    }

    public boolean isEmpty() {
        return this.nowsize == 0;
    }

    public int size() {
        return this.nowsize;
    }

    public void printDeque() {
        for (int i = 0; i < this.nowsize; i++) {
            System.out.print(this.get(i) + " ");
        }
    }

    private boolean pointerHelper() {
        return this.nowsize == 0;
    }

    public T removeFirst() {
        if (this.pointerHelper()) {
            return null;
        } else {
            T item = this.initialarrays[posModular(this.size, this.first)];
            this.initialarrays[posModular(this.size, this.first)] = null;
            this.nowsize--;
            this.first++;
            return item;
        }
    }

    public T removeLast() {
        if (this.pointerHelper()) {
            return null;
        } else {
            T item = this.initialarrays[posModular(this.size, this.last)];
            this.initialarrays[posModular(this.size, this.last)] = null;
            this.nowsize--;
            this.last--;
            return item;
        }
    }

    public T get(int index) {
        return this.initialarrays[this.posModular(this.size, this.first + index)];
    }
}
