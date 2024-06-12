
// dijkstra's algorithms
// to find the shortest path from a source to all the other vertices
//  * A graph is given as an adjacency list.
//  * The graph is weighted and directed.
//  * The graph is represented as a matrix
//  * make a boolean array to keep track of the visited nodes
//  * make a distance array to keep track of the minimum distance from the source
//  * set the distance of the source to 0
//  * set the distance of all the other nodes to infinity
//  * while the number of edges is less than the number of vertices - 1
//  * find the node with the minimum distance
//  * mark the node as visited
//  * update the distance of all the nodes that are not visited
//  * print the distance
//  * end while

import java.util.Arrays;

public class Dijkstra {
    public static void main(String[] args) {
        int graph[][] = new int[][] {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 }
        };

        int n = graph.length;

        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(visited, false);
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int x = 0;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && distance[j] < min) {
                    min = distance[j];
                    x = j;
                }
            }
            visited[x] = true;
            for (int j = 0; j < n; j++) {
                // if not visited and there is an edge and the distance is not infinity and the
                // distance is less than the minimum distance
                // j denotes the index of all the vertices that are connected from max
                if (!visited[j] && graph[x][j] != 0 && distance[x] != Integer.MAX_VALUE
                        && distance[x] + graph[x][j] < distance[j]) {
                    distance[j] = distance[x] + graph[x][j];
                }
            }
            System.out.println(x + " " + distance[x]);
        }
    }

}
