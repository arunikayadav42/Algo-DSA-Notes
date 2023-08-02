import java.util.ArrayList;
import javafx.util.Pair;
import java.util.*;

/**
 * Store the adjancency list as pair(neighbour, edge weight)
 */
public class Dijkstras {
    private int V;

    private ArrayList<ArrayList<Integer[]>> adj;

    Dijkstras(int v) {
        this.V = v;
        this.adj = new ArrayList<ArrayList<Integer[]>>();
        for(int i = 0; i < v; i++) {
            this.adj.add(new ArrayList<Integer[]>());
        }
    }

    private void addEdge(int v, int w, int edgeWeight) {
        this.adj.get(v).add(new Integer[]{w, edgeWeight});
    }

    private void dijsktra(int sourceNode) {
        //Initialize
        //min heap
        //distance with entries as infinite big value
        PriorityQueue<Integer[]> pq = 
        new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        //distance of source node is 0 from itself
        distance[sourceNode] = 0;
        pq.add(new Integer[]{0, sourceNode});

        while(!pq.isEmpty()) {
            int edgeWeight = pq.peek()[0];
            int node = pq.peek()[1];

            for(Integer[] neighbour: adj.get(node)) {
                int neighbourVertex = neighbour[0];
                int neighbourEdgeWeight = neighbour[1];

                //for each neighbour, check if the distance using current vertex
                //is less than in the distance array
                if(distance[neighbourVertex] > edgeWeight + neighbourEdgeWeight)
                    {   
                        //if yes, then that becomes a part of the shortest path
                        distance[neighbourVertex] = edgeWeight + neighbourEdgeWeight;
                        pq.add(new Integer[]{distance[neighbourVertex], neighbourVertex});
                    }
            }

        }

        for(int dist: distance)
            System.out.print(dist+" , ");

        System.out.println();
    }

    public static void main(String[] args) {
        Dijkstras g = new Dijkstras(6);
        g.addEdge(5, 2, 1);
        g.addEdge(5, 4, 1);
        g.addEdge(4, 0, 4);
        g.addEdge(4, 1, 6);
        g.addEdge(2, 3, 2);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 5);

        g.dijsktra(0);
    }

}
