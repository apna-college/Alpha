package Graphs;
import java.util.*;

public class Topological_sorting {
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

    public static void topo_sorting(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                topo_sorting_Util(graph,i,vis,st);
            }
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop()+" ");
        }
    }

    public static void topo_sorting_Util(ArrayList<Edge>[] graph,int curr,boolean vis[], Stack<Integer> st){
        vis[curr] = true ;

        for(int i=0 ; i< graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.destination]){
                topo_sorting_Util(graph, e.destination, vis, st);
            }
            
        }
        st.push(curr);
    }

    public static void main(String[] args) {
        int v = 5 ;
        ArrayList<Edge> graph[] = new ArrayList [v]; // this array is empty so, we have to fill with arraylist

        for(int i=0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<>();
        }

        // 2 - vertex
        graph[2].add(new Edge(2, 3, 1));

        // 3 - vertex
        graph[3].add(new Edge(3, 1, 1));

        // 4 - vertex
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[4].add(new Edge(5, 0, 1));
        graph[4].add(new Edge(5, 2, 1));

        topo_sorting(graph);
    }

}
