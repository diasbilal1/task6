import java.util.*;


public class MyGraph<V> {
    private final boolean undirected;
    private Map<V, Vertex<V>> map = new HashMap<>();

    public MyGraph() {
        this.undirected = true;
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V v) {
        map.put(v, new Vertex<>(v));
    }

    public void addEdge(V source, V dest) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).addAdjacentVertex(map.getOrDefault(dest, new Vertex<>(dest)), 0);

        if (undirected)
            map.get(dest).addAdjacentVertex(map.get(source), 0);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex<V> v : map.values()) {
            count += v.getEdgesCount();
        }

        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(V v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(V source, V dest) {
        if (!hasVertex(source) || !hasVertex(dest)) return false;
        return map.get(source).hasEdge(map.get(dest));
    }

    public Iterable<Vertex<V>> adjacencyList(V v) {
        if (!hasVertex(v)) return null;
        List<Vertex<V>> res = new LinkedList<>();
        res.addAll(map.get(v).getAdjacentVertices().keySet());
        return res;
    }
}