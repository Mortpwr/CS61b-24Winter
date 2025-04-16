public class LinkedListDeque<T> {
    public int size;
    public ItemNode head = new ItemNode();
    public LinkedListDeque() {
        this.size = 1;
    }
    public LinkedListDeque(T item) {
        this.size = 1;
        this.head.next = new ItemNode(item, head, null);
        this.head.prev = head.next;
    }
    public void addFirst(T item){
        ItemNode newNode = new ItemNode(item, head, head.next);
        head.next.prev = newNode;
        head.next = newNode;
        this.size++;
    }
    public void addLast(T item){
        ItemNode newNode = new ItemNode(item, head.prev, head);
        head.prev.next = newNode;
        head.prev = newNode;
        this.size++;
    }
    public boolean isEmpty(){
        return this.size == 1;
    }
    public int size(){
        return this.size - 1;
    }
    public void printHelper(int length, ItemNode head){
        if(length > 0){
            System.out.print(head.item + " ");
            printHelper(length - 1, head.next);
        }
    }
    public void printDeque(){
        ItemNode first = this.head.next;
        printHelper(this.size - 1, first);
    }
    public T removeFirst(){
        if(this.isEmpty()){
            T item =  this.head.next.item;
            this.head.next = null;
            return item;
        }
        T item = this.head.next.item;
        ItemNode second = this.head.next.next;
        this.head.next = second;
        second.prev = this.head;
        this.size--;
        return item;
    }
    public T removeLast(){
        if(this.isEmpty()){
            T item =  this.head.prev.item;
            this.head.prev = null;
            return item;
        }
        T item = this.head.prev.item;
        ItemNode second = this.head.prev.prev;
        this.head.prev = second;
        second.next = this.head;
        this.size--;
        return item;
    }
    public T get(int index){
        ItemNode first = this.head.next;

        while(index + 1 <= this.size && index >= 0){
            if(index == 0){
                return first.item;
            }
            first = first.next;
            index--;
        }
        return null;
    }
    public T getRecursiveHelper(ItemNode node, int index){
        if(index == 0){
            return node.item;
        }
        else{
            return getRecursiveHelper(node.next, index - 1);
        }
    }
    public T getRecursive(int index){
        ItemNode first = this.head.next;
        return getRecursiveHelper(first, index);
    }
    private class ItemNode{
       public ItemNode prev;
       public ItemNode next;
       public T item;
       public ItemNode(T item, ItemNode prev, ItemNode next){
           this.item = item;
           this.prev = prev;
           this.next = next;
       }
       public ItemNode(){
           this.item = null;
           this.prev = this;
           this.next = this;
       }
    }
}
