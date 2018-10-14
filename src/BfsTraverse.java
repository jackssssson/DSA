import java.util.*;

public class BfsTraverse {
    private List<List<Integer>> vertices;

    private BfsTraverse(int n){
        vertices = new ArrayList<>();

        for (int i = 0; i < n + 1; i++){
            vertices.add(new ArrayList<>());
        }
    }

    private void addEdge(int x, int y){
        vertices.get(x).add(y);
        vertices.get(y).add(x);
    }

    private void bfs(int vertex){
       Queue<Integer> queue = new ArrayDeque<>();
       Set<Integer> visited = new HashSet<>();

       queue.offer(vertex);
       visited.add(vertex);

       while (!queue.isEmpty()){
           int value = queue.poll();
           System.out.println(value);

           for (int nextVertex : vertices.get(value)){
               if (visited.contains(nextVertex)){
                   continue;
               }

               queue.offer(nextVertex);
           }
       }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        BfsTraverse graph = new BfsTraverse(5);

        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.bfs(in.nextInt());
    }
}
