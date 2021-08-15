package Homework7;

import java.util.Objects;

public class Vertex {
    private final String label;
    private boolean visited;
    private int path;
    private String predecessor;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex(String label) {
        this.label = label;
    }


    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return "Vertex{ " + label + " }";
    }

    public void setPredecessor(String predecessor) {
        this.predecessor = predecessor;
    }

    public void setPath(int path) {
        this.path = path;
    }

    public int getPath() {
        return path;
    }

    public String getPredecessor() {
        return predecessor;
    }
}

