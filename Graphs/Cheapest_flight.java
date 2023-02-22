package Graphs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cheapest_flight {

    static class Info{
        int v;
        int cost ;
        int stops;
        public Info(int v,int c,int s){
            this.v = v ;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int cheapestFlight(int n,int flights[][],int src,int dest,int k){
        ArrayList<Edge> [] graph = new ArrayList[n];
        create_graph(graph, flights);

        int dis[] = new int[graph.length];
        for (int i = 0; i < dis.length; i++) {
            if(i != src)
            dis[i] = Integer.MAX_VALUE;
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0)); // starts source and  with cost 0 and stops 0

        while (!q.isEmpty()) {
            Info curr = q.remove();

            // check  first that curr stops is not more than our max k stops
            if(curr.stops > k)
            break ;

            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.source;
                int v = e.destination ;
                int wt = e.weight;

                if(dis[u] != Integer.MAX_VALUE && dis[u]+wt < dis[v] && curr.stops <= k){
                    dis[v] = dis[u]+wt;
                    q.add(new Info(v, dis[v], curr.stops+1));
                }
            }
        }
        
        if(dis[dest] == Integer.MAX_VALUE)
        return -1;
        else
        return dis[dest];
    }

    public static void create_graph(ArrayList<Edge>[] graph,int flights[][]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }
    public static void main(String[] args) {
        int n=4;
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0 , dest =3 , k = 1 ;

        System.out.println(cheapestFlight(n, flights, src, dest, k));
    }
    static class Edge{
        int source;
        int destination;
        int weight;
        public Edge(int s,int d,int w){
            this.source = s;
            this.destination = d ;
            this.weight = w ;
        }
    }

}
