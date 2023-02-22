// find shortest distance for negative weighted graph

package Graphs;
import java.util.*;

public class BellmanFord_algo {

    public static void Bellman(ArrayList<Edge>[] graph,int src){
        int dist[] = new int[graph.length];

        for(int i = 0 ;i < dist.length ; i++){
            if(i != src)
            dist[i] = Integer.MAX_VALUE;
        }

        int V = graph.length ;

        for(int i = 0 ; i < V-1 ; i++){ // O(V*E)
            for(int j= 0 ; j < graph.length ; j++){ // O(E)
                for(int k= 0 ; k < graph[j].size() ; k++){
                    Edge e = graph[j].get(k);

                    int u = e.source ;
                    int v = e.destination ; 
                    int w = e.weight ;

                    if(dist[u] != Integer.MAX_VALUE && dist[u]+w < dist[v]){
                        dist[v] = dist[u]+w ;
                    }
                }
            }
        }

        for(int i= 0 ; i< dist.length ; i++)
        System.out.print(dist[i]+" ");
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[5];
        Create_graph(graph);

        Bellman(graph, 0) ;
    }

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int s, int d, int w) {
            this.source = s;
            this.destination = d;
            this.weight = w;
        }
    }
    public static void Create_graph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<>();

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        //graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1,-1));
        //graph[4].add(new Edge(4, 5, 5));
    }
}
