package Graphs;
import java.util.*;

public class Create_graph {
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
    public static void main(String[] args) {
        int v = 5 ;
        ArrayList<Edge> graph[] = new ArrayList [v]; // this array is empty so, we have to fill with arraylist

        for(int i=0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<>();
        }

        // 0 - vertex
        graph[0].add(new Edge(0, 1, 5));

        //1 - vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 - vertex
        graph[2].add(new Edge(2,1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        // 3 - vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // 4 - vertex
        graph[4].add(new Edge(4, 2, 4));


        // 2's neighbour
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.destination);
        }   

        bfs(graph);
        dfsUtil(graph, 0, new boolean[v]);
        System.out.println(hasPath(graph, 0, 44, new boolean[v]));
    }



    // for not connected graph
    public static void bfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                bfsUtil(graph,vis);
            }
        }
    }
    //utility function
    public static void bfsUtil(ArrayList<Edge>[] graph,boolean vis[]){ // O(v+e) 
        Queue<Integer> q = new LinkedList<>();
        // boolean vis[] = new boolean[graph.length];
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if(!vis[curr]){
                System.out.print(curr + " ");
                vis[curr] = true ;
                for(int i=0 ; i < graph[curr].size() ; i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.destination);
                }
            }
        }
    }

    
    // for not connected graph
    public static void dfs(ArrayList<Edge>[] graph){
        boolean vis[]= new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            dfsUtil(graph, i, vis);
        }
    }

    // utility function
    public static void dfsUtil(ArrayList<Edge>[] graph,int curr ,boolean vis[]){ // O(v+e)
        System.out.print(curr+" ");
        vis[curr] = true ;

        for(int i=0 ; i< graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.destination]){
                dfsUtil(graph, e.destination, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest,boolean vis[]){ // O(v+e)
        if(src == dest)
        return true ;

        vis[src] =true ;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if(!vis[e.destination] && hasPath(graph, e.destination, dest, vis))
            return true ;
        }
        return false;
    }
}
