public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graphW = new WeightedGraph<>(true);

        graphW.addEdge("Barcelona", "Madrid", 2.1);
        graphW.addEdge("Barcelona", "Seville", 7.2);
        graphW.addEdge("Seville", "Madrid", 3.9);
        graphW.addEdge("Madrid", "Bilbao", 3.5);
        graphW.addEdge("Seville", "Valencia", 5.4);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(graphW, "Barcelona");
        outputPath(djk, "Bilbao");

        MyGraph<String> graph = new MyGraph<>();

        System.out.println("\n--------------------------------");

        graph.addEdge("Barcelona", "Madrid");
        graph.addEdge("Barcelona", "Seville");
        graph.addEdge("Seville", "Madrid");
        graph.addEdge("Madrid", "Bilbao");
        graph.addEdge("Seville", "Valencia");

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, "Barcelona");
        outputPath(dfs, "Bilbao");

        System.out.println("\n--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Barcelona");
        outputPath(bfs, "Bilbao");
    }

    public static void outputPath(Search<String> search, String key) {
        Iterable<String> path = search.pathTo(key);
        if (path != null) {
            for (String v : path) {
                System.out.print(v + " -> ");
            }
        } else {
            System.out.println("No path found.");
        }
    }
}
