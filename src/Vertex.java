import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    public boolean hasEdge(Vertex<V> dest) {
        return adjacentVertices.containsKey(dest);
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    public int getEdgesCount() {
        return adjacentVertices.size();
    }

    public V getData() {
        return data;
    }

    public double getWeight(Vertex<V> v) {
        return adjacentVertices.getOrDefault(v, 0.0);
    }
}
