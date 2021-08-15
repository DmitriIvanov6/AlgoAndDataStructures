package Homework7;

public class Main {
    public static void main(String[] args) {
        createGraph();

    }

    private static void createGraph() {
        Graph graph = new GraphImpl(10);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        graph.addVertex("J");


        graph.addEdge("A", "B", 2);
        graph.addEdge("B", "E", 3);
        graph.addEdge("E", "J", 9);

        graph.addEdge("A", "C", 1);
        graph.addEdge("C", "F", 5);
        graph.addEdge("F", "H", 3);
        graph.addEdge("H", "J", 4);

        graph.addEdge("A", "D", 3);
        graph.addEdge("D", "G", 1);
        graph.addEdge("G", "I", 9);
        graph.addEdge("I", "J", 9);








//        graph.bfs("A");
        System.out.println("Size of graph is " + graph.getSize());
        graph.display();
        graph.shortestPath("A", "J");
    }
}
