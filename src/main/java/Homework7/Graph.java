package Homework7;


import java.util.Stack;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, String... others);

    boolean addEdge(String startLabel, String secondLabel, int weight);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

    void shortestPath(String startLabel, String endLabel);

//    Stack<String> findShortPathViaBfs(String startLabel, String finishLabel);

}

