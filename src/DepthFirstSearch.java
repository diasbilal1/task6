

public class DepthFirstSearch<V> extends Search<V> {
    public DepthFirstSearch(MyGraph<V> graph, V source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(MyGraph<V> graph, V current) {
        marked.add(current);
        count++;
        for (Vertex<V> v : graph.adjacencyList(current)) {
            if (!marked.contains(v.getData())) {
                if(current != null) edgeTo.put(v.getData(), current);
                dfs(graph, v.getData());
            }
        }
    }
}