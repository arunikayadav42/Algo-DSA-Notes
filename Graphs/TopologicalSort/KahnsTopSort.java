import java.util.*;
import java.io.*;

/**
 * Time Complexity: O(V+E)
 * BFS method for Topological Sort
 * Top Sort is only valid for Directed Acyclic Graph
 * remember to check for cycles in this algo
 */
public class KahnsTopSort {
    private int V;

    private ArrayList<ArrayList<Integer>> adj;

    KahnsTopSort(int v) {
        this.V = v;
        this.adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < v; i++)
            this.adj.add(new ArrayList<Integer>());
    }

    private void addEdge(int v, int w) {
        this.adj.get(v).add(w);
    }

    private int[] findIncomingDegree() {
        int[] incomingDegree = new int[V];
        for(int i = 0; i < V; i++) {
            for(int neighbour: adj.get(i))
                incomingDegree[neighbour]++;
        }

        return incomingDegree;
    }

    private void kahnsTopSortUtil(int[] incomingDegree) {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++)
            if(incomingDegree[i] == 0)
                q.add(i);

        while(!q.isEmpty()) {
            int curr = q.poll();

            System.out.print(curr+", ");
            for(int i: adj.get(curr))
                {
                    incomingDegree[i]--;
                    if(incomingDegree[i] == 0)
                        q.add(i);
                }
        }
    }

    public static void main(String[] args) {
        KahnsTopSort g = new KahnsTopSort(6);

        g.addEdge(5, 0);
        g.addEdge(5, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(3, 1);
        g.addEdge(1, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);

        int[] incomingDegree = g.findIncomingDegree();
        g.kahnsTopSortUtil(incomingDegree);
    }
}
