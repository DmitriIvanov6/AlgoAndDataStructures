package Homework3;

public class QueueImpl<E> implements Queue<E> {

    public static final int HEAD_DEFAULT = 0;
    public static final int TAIL_DEFAULT = 0;
    protected final E[] data;
    protected int size;

    protected int tail;
    protected int head;

    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object [maxSize];
        this.head = HEAD_DEFAULT;
        this.tail = TAIL_DEFAULT;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }
        data[tail] = value;
        tail++;
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }
        E value = data[head];
        for (int i = 0; i < tail - 1; i++){
            data[i] = data[i + 1];
        }
        if (tail < data.length){
            data[tail] = null;
        }
        tail--;
        size--;

        return value;
    }

    @Override
    public E peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("--> [");
        for (int i = head; i < tail; i++) {
            sb.append(data[i]);
            if (i != tail - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}