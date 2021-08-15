package Homework7;

import java.util.*;

public class GraphImpl implements Graph {
    private final List<Vertex> vertexList;
    private final boolean[][] adjMatrix;
    private final int[][] weightMatrix;
    private int pathLength = 0;


    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new boolean[maxVertexCount][maxVertexCount];
        this.weightMatrix = new int[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);
        for (String other : others) {
            result &= addEdge(startLabel, other);
        }
        return result;
    }

    public boolean addEdge(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = true;
//        Тут для интереса задал рандомный вес от 1 до 10
        Random random = new Random();
        weightMatrix[startIndex][endIndex] = random.nextInt(10) + 1;
//        adjMatrix[endIndex][startIndex] = true;

        return true;
    }

    public boolean addEdge(String startLabel, String endLabel, int weight) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = true;

        weightMatrix[startIndex][endIndex] = weight;


        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j]) {
                    System.out.print(" -> " + weightMatrix[i][j] + " " + vertexList.get(j));

                }
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
    }


    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        stack.push(vertex);
        vertex.setVisited(true);
    }


    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
    }

    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        stack.add(vertex);
        vertex.setVisited(true);

    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    public void pathInc(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] && vertexList.get(i).getPath() > vertex.getPath() + weightMatrix[currentIndex][i]) {
                vertexList.get(i).setPredecessor(vertex.getLabel());
                vertexList.get(i).setPath(vertex.getPath() + weightMatrix[currentIndex][i]);
            }
        }
    }

    @Override
    public void shortestPath(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);
        String pred = startLabel;

        for (Vertex value : vertexList) {
//            в алгоритме максимальное значение нужно установить в бесконечность, но у нас оно получиться не более 40, при рандоме в методе
            value.setPath(41);
        }

        if (startIndex == -1 || endIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);
        vertex.setPredecessor(null);
        vertex.setPath(0);
        System.out.println();

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                pred = queue.peek().getLabel();
                pathLength = queue.peek().getPath();
            }

            vertex = getNearUnvisitedVertex(queue.peek());

            if (vertex != null) {
                if (vertex.getPath() > pathLength + weightMatrix[indexOf(pred)][indexOf(vertex.getLabel())]) {
                    vertex.setPath(pathLength + weightMatrix[indexOf(pred)][indexOf(vertex.getLabel())]);
                    vertex.setPredecessor(pred);
                }
                visitVertex(queue, vertex);
                pathInc(vertex);
            } else {
                queue.remove();

            }
        }
        vertex = vertexList.get(indexOf(endLabel));
        System.out.println("Кратчайший путь до точки " + endLabel + " равен " + vertex.getPath());
        System.out.println(predecessors(endLabel));
    }

    public String predecessors(String label) {
        Stack<String> predec = new Stack<>();
        Vertex vertex = vertexList.get(indexOf(label));
        predec.push(label);
        while (label != null) {
            label = vertex.getPredecessor();

            if (vertex.getPredecessor() != null){
                predec.push(vertex.getPredecessor());
            }
             if ( label != null){
                vertex = vertexList.get(indexOf(label));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Путь: ");
        while(!predec.empty()){
            sb.append(predec.pop());
            sb.append(" ");
        }
        return sb.toString();
    }

}


