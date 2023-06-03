import java.util.*;

public class WeightedGraph<V> {
    private boolean undirected;
    private Map<V, Vertex<V>> vertices;

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        this.vertices = new HashMap<>();
    }

    public void addVertex(V v) {
        vertices.put(v, new Vertex<>(v));
    }

    public void addEdge(V source, V dest, double weight) {
        if (!vertices.containsKey(source)) {
            addVertex(source);
        }

        if (!vertices.containsKey(dest)) {
            addVertex(dest);
        }

        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(dest);

        if (sourceVertex.hasEdge(destVertex) || source.equals(dest)) {
            return; // reject parallels & self-loops
        }

        sourceVertex.addAdjacentVertex(destVertex, weight);

        if (undirected) {
            destVertex.addAdjacentVertex(sourceVertex, weight);
        }
    }

    public int getVerticesCount() {
        return vertices.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex<V> v : vertices.values()) {
            count += v.getEdgesCount();
        }

        if (undirected) {
            count /= 2;
        }

        return count;
    }

    public boolean hasVertex(V v) {
        return vertices.containsKey(v);
    }

    public boolean hasEdge(V source, V dest) {
        if (!hasVertex(source) || !hasVertex(dest)) {
            return false;
        }
        return vertices.get(source).hasEdge(vertices.get(dest));
    }

    public Iterable<Vertex<V>> adjacencyList(V v) {
        if (!hasVertex(v)) {
            return null;
        }
        return vertices.get(v).getAdjacentVertices().keySet();
    }

    public Vertex<V> getVertex(V vertex) {
        return vertices.get(vertex);
    }
}
