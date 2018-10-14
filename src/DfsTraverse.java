import java.util.*;

public class DfsTraverse {
    private List<List<Integer>> vertices;
    private Set<Integer> visited;

    private DfsTraverse(int n) {
        visited = new HashSet<>();
        vertices = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            vertices.add(new ArrayList<>());
        }
    }

    private void addEdge(int x, int y) {
        vertices.get(x).add(y);
        vertices.get(y).add(x);
    }

    private void dfs(int vertex){
        System.out.println(vertex);
        visited.add(vertex);

        for (int nextVertex : vertices.get(vertex)){
            if (visited.contains(nextVertex)){
                continue;
            }

            dfs(nextVertex);
        }
    }

    public static void main(String[] args) {
        DfsTraverse graph = new DfsTraverse(5);
        Scanner in = new Scanner(System.in);

        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.dfs(in.nextInt());
    }
}
