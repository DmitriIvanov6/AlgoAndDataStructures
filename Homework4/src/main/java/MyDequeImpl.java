public class MyDequeImpl<E> implements MyDeque<E> {

    private final TwoSideLinkedList<E> data;

    public MyDequeImpl(TwoSideLinkedList<E> data) {
        this.data = new TwoSideLinkedListImpl<>();

    }


    @Override
    public boolean insertLeft(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E removeLeft() {
        return data.removeFirst();
    }

    @Override
    public E removeRight() {
        return data.removeLast();
    }


    @Override
    public boolean insert(E value) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E peekFront() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }


    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        data.display();
    }


}