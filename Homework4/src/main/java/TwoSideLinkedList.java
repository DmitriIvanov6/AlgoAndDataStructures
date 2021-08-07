public interface TwoSideLinkedList<E> extends LinkedList<E> {

    void insertLast(E value);

    E getLast();

// Прищлось добавить, чтобы работало
    E removeLast();
}

