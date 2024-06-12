import java.util.Scanner;
import java.util.Arrays;

// PRIM Algorithm to find the minimum spanning tree

// The time complexity of the Prim's algorithm is O(V^2) but 
// with the help of min heap, we can reduce it to O(E log V).

// The space complexity of the Prim's algorithm is O(V^2) but
// with the help of min heap, we can reduce it to O(V + E).

// form a visited boolean array
// set the first node as visited
// while the number of edges is less than the number of vertices - 1
// check all the nodes that are not visited and 
// check if the edge is minimum
// if minimum then update the minimum edge
// mark the node as visited
// print the edge
// end while

public class prims2 {
    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);
        // int n=scan.nextInt();
        // int[][] graph = new int[n][n];
        // for(int i=0;i<n;i++){
        // for(int j=0;j<n;j++){
        // graph[i][j]=scan.nextInt();
        // }
        // }

        int graph[][] = new int[][] {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 }
        };

        int n = graph.length;

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        int edge = 0;
        visited[0] = true;
        while (edge < n - 1) {
            int min = Integer.MAX_VALUE;
            int x = 0;
            int y = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i] == true) {
                    for (int j = 0; j < n; j++) {
                        if (!visited[j] && graph[i][j] != 0) {
                            if (graph[i][j] < min) {
                                min = graph[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            edge++;
            visited[y] = true;

            System.out.println(x + " " + y + " " + graph[x][y]);
        }

    }
}
