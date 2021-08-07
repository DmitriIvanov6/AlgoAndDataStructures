public class Main {
    public static void main(String[] args) {
        testDeque();
        testLinkedList();
    }

        private static void testLinkedList() {
        LinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);

        linkedList.display();

        for (Integer value : linkedList) {
            System.out.println(value);
        }
    }
    private static void testDeque() {
        MyDequeImpl<Integer> myDeque = new MyDequeImpl<>(new TwoSideLinkedListImpl<>());
        myDeque.insertLeft(3);
        myDeque.insertLeft(2);
        myDeque.insertLeft(1);
        myDeque.insertRight(1);
        myDeque.insertRight(2);
        myDeque.insertRight(3);

        myDeque.display();
        myDeque.removeLeft();
        myDeque.removeRight();

        myDeque.display();


    }


}
