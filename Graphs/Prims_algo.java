package Graphs;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims_algo {
    static class Pair implements Comparable<Pair>{
        int v;
        int cost ;

        public Pair(int v,int cost){
            this.v = v ;
            this.cost = cost ;
        }

        public int compareTo(Pair p2){
            return this.cost - p2.cost ;
        }
    }

    public static int prims(ArrayList<Edge>[] graph){ //O(E*logE)
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int final_cost = 0;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if(!vis[curr.v]){
                vis[curr.v] = true ;
                final_cost += curr.cost ;

                for(int i=0;i<graph[curr.v].size();i++){
                    Edge e = graph[curr.v].get(i);

                    pq.add(new Pair(e.destination, e.weight));
                }
            }
        }

        return final_cost;
    }


    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        Create_graph(graph);

        System.out.println("Final minimum cost of spanning tree is - "+prims(graph));
    }

    static class Edge{
        int source;
        int destination ;
        int weight;

        public Edge(int s,int d,int w){
            this.source = s ;
            this.destination = d ;
            this.weight = w ;
        }
    }

    public static void Create_graph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<>();

        graph[0].add(new Edge(0, 1, 4));
        graph[0].add(new Edge(0, 3, 45));
        graph[0].add(new Edge(0, 2, 34));

        graph[1].add(new Edge(1, 0, 4));
        graph[1].add(new Edge(1,2,5));
        graph[1].add(new Edge(1, 3, 5));

        graph[2].add(new Edge(2, 1, 5));
        graph[2].add(new Edge(2, 0, 34));

        graph[3].add(new Edge(3, 1, 5));
        graph[3].add(new Edge(3, 0, 45));

    }
}
