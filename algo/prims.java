import java.util.Scanner;

class Main {
    static final int INF = 999;

    static int minKey(int key[], boolean selected[], int V) {
        int min = INF, min_index = -1;
        for (int v = 0; v < V; v++) {
            if (selected[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }

    static void printMST(int parent[], int graph[][], int V) {
        for (int i = 1; i < V; i++)
            System.out.printf("%d %d %d\n", parent[i], i, graph[i][parent[i]]);
    }

    static void primMST(int graph[][], int V) {
        int parent[] = new int[V];
        int key[] = new int[V];
        boolean selected[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            key[i] = INF;
            selected[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;
        for (int count = 1; count < V; count++) {
            int u = minKey(key, selected, V);
            selected[u] = true;
            for (int v = 0; v < V; v++) {
                if ((graph[u][v] != 0) && selected[v] == false &&
                        graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent, graph, V);
    }

    public static void main(String a[]) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int i, j;
        int graph[][] = new int[V][V];
        for (i = 0; i < V; i++) {
            for (j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        primMST(graph, V);
    }
}