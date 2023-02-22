package Graphs;

import java.util.*;

public class Dijkstra_algo {

    static class Pair implements Comparable<Pair> {
        int node;
        int path; // current distance

        public Pair(int n, int p) {
            this.node = n;
            this.path = p;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void Dijkstra(ArrayList<Edge>[] graph, int src) {// O(v+ElogV) else(without dijk) o(v^2)
        int dis[] = new int[graph.length];           // storing mimumum distance of every node
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < dis.length; i++) {
            if (i != src) // i's distance intialize with 0
                dis[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0)) ; // add source and thier distance is  0

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.node]) {
                vis[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);

                    int u = e.source;
                    int v = e.destination;
                    int w = e.weight;

                    if (dis[u] + w < dis[v]) {
                        dis[v] = dis[u] + w;
                        pq.add(new Pair(v, dis[v])) ;
                    }
                }
            }
        }
        for (int i = 0; i < dis.length; i++)
        System.out.print(dis[i]+" ");
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        Create_graph(graph);

        Dijkstra(graph, 0) ;
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

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }
}
