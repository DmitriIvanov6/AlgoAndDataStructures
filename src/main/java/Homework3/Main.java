package Homework3;

public class Main {
    public static void main(String[] args) {
//        Задание 1
//        System.out.println("Пропущено: " + FindNumber.findNumber( 1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16));
//        System.out.println("Пропущено: " + FindNumber.findNumber(1, 2, 4, 5, 6));
//        System.out.println("Пропущено: " + FindNumber.findNumber());
//        testQueue();
        testDeque();






    }

    private static void testDeque() {
        Deque<Integer> deque = new DequeImpl<>(5);
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.insertLeft(4);
        deque.insertLeft(5);
        deque.display();
        System.out.println("Длина очереди: " + deque.size());
        deque.removeRight();
        deque.display();
        System.out.println("Длина очереди: " + deque.size());
        deque.removeRight();
        deque.removeRight();
        deque.removeRight();
        deque.removeRight();
        deque.display();
        System.out.println("Длина очереди: " + deque.size());
        deque.insertRight(1);
        deque.insertRight(2);
        deque.insertRight(3);
        deque.insertRight(4);
        deque.insertRight(5);
        deque.insertRight(5);
        deque.display();
        System.out.println("Длина очереди: " + deque.size());
        deque.removeLeft();
        deque.removeLeft();
        deque.insertLeft(7);
        deque.insertLeft(6);
        deque.insertLeft(6);
        deque.display();
        System.out.println("Длина очереди: " + deque.size());

    }



//    private static void testQueue() {
//        Queue<Integer> queue = new QueueImpl<>(5);
//        System.out.println("add element: " + queue.insert(34));
//        System.out.println("add element: " + queue.insert(12));
//        System.out.println("add element: " + queue.insert(20));
//        System.out.println("add element: " + queue.insert(16));
//        System.out.println("add element: " + queue.insert(14));
//        queue.display();
//        System.out.println(queue.remove());
//        System.out.println(queue.peekFront());
//        System.out.println(queue.size());
//        queue.remove();
//        queue.remove();
//        queue.remove();
//        queue.remove();
//        queue.display();
//        queue.insert(123);
//        queue.insert(123);
//        queue.insert(123);
//        queue.insert(123);
//        queue.insert(124);
//        queue.display();
//
//    }
}
