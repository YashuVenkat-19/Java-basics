import java.util.Scanner;

public class floydWarshall {
    private static final int INF = 9999;
    static int N;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = INF;
                }
            }
        }

        int edges = scan.nextInt();
        for (int i = 0; i < edges; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            int value = scan.nextInt();

            graph[start][end] = value;
            graph[end][start] = value;
        }
        scan.close();

        // printing D0 matrix
        System.out.println("Original Matrix");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == INF) {
                    System.out.print("∞ ");
                } else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Solution:-");
        floydWarshallSol(graph);
    }

    public static void floydWarshallSol(int[][] graph) {
        int[][] dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // solution print
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("∞ ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}