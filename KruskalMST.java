import java.util.*;

class Edge {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class KruskalMST {
    int V, E;
    Edge[] edges;

    public KruskalMST(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
    }

    public void addEdge(int index, int src, int dest, int weight) {
        edges[index] = new Edge(src, dest, weight);
    }

    public int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    public void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    public void kruskalMST() {
        Edge[] result = new Edge[V];
        int e = 0;
        int i = 0;

        // Sort edges by weight using bubble sort
        for (int j = 0; j < E - 1; j++) {
            for (int k = 0; k < E - j - 1; k++) {
                if (edges[k].weight > edges[k + 1].weight) {
                    Edge temp = edges[k];
                    edges[k] = edges[k + 1];
                    edges[k + 1] = temp;
                }
            }
        }

        int[] parent = new int[V];
        // Arrays.fill(parent, -1);

        while (e < V - 1 && i < E) {
            Edge nextEdge = edges[i++];
            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                union(parent, x, y);
            }
        }

        System.out.println("Edges in the MST:");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].weight);
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        int E = 5; // Number of edges

        KruskalMST graph = new KruskalMST(V, E);

        // Add edges
        graph.addEdge(0, 0, 1, 10);
        graph.addEdge(1, 0, 2, 6);
        graph.addEdge(2, 0, 3, 5);
        graph.addEdge(3, 1, 3, 15);
        graph.addEdge(4, 2, 3, 4);

        graph.kruskalMST();
    }
}
