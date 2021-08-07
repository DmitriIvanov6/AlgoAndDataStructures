
public class TwoSideLinkedListImpl<E> extends MyLinkedList<E> implements TwoSideLinkedList<E> {
    protected Node<E> lastElement;

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value, null);

        if (isEmpty()) {
            firstElement = newNode;
        } else {
            lastElement.next = newNode;
        }

        lastElement = newNode;
        size++;
    }

    @Override
    public E getLast() {
        return getValue(lastElement);
    }

    @Override
    public E removeLast(){
        if (isEmpty()) return null;
        Node<E> current = firstElement;
        Node<E> previous;
        E removedValue = getLast();
        while (current != null) {
            previous = current;
            current = current.next;
            if (current == lastElement) {

                lastElement = previous;
                previous.next = null;
            }
            size--;
        } return removedValue;
    }


    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();
        if (isEmpty()) {
            lastElement = null;
        }
        return removedValue;
    }


    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        } else if (current == lastElement) {
            lastElement = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;
        return true;
    }


}

