package Graphs;
import java.util.*;

public class Cycle_detection {
    static class Edge{
        int source;
        int destination ;
        int weight ;
        public Edge(int s,int d,int w){
            this.source = s ;
            this.destination = d ;
            this.weight = w ;
        }
    }
    
    public static boolean cycle_detect(ArrayList<Edge>[] graph){
        boolean vis[]= new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                if(cycle_detect_Util(graph,i,-1,vis))
                return true;
            }
        }
        return false;
    }

    public static boolean cycle_detect_Util(ArrayList<Edge>[] graph,int curr,int par,boolean vis[]){

        vis[curr] = true ;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            
            // case  3 - neighbor not visited now but it returns that i am in cycle then return true
            if(!vis[e.destination]){
                if(cycle_detect_Util(graph, e.destination, curr, vis))
                return true;
            }
        
            // case 1 - neighbor is vistited but parent is not then always cycle
            else if(vis[e.destination] && e.destination != par)
            return true;

            // case 2 - neighbor visited ans parent also then -> continue;
        }

        return false;
    }

    public static void main(String[] args) {
        int v = 5 ;
        ArrayList<Edge> graph[] = new ArrayList [v]; // this array is empty so, we have to fill with arraylist

        for(int i=0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<>();
        }

        // 0 - vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        //1 - vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        // 2 - vertex
        // graph[2].add(new Edge(2,0, 1));

        // 3 - vertex
        graph[3].add(new Edge(3, 4, 1));

        System.out.println(Cycl_det_directed(graph));
    }

    public static boolean Cycl_det_directed(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                if(Cycl_det_directed_Util(graph, i, vis, stack))
                return true ;
            }
        }
        return false ;
    }

    public static boolean Cycl_det_directed_Util(ArrayList<Edge>[] graph,int curr,boolean vis[],boolean stack[]){
        vis[curr] = true ;
        stack[curr] = true ;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(stack[e.destination] == true)
            return true ;

            if(!vis[e.destination] && Cycl_det_directed_Util(graph, e.destination, vis, stack))
            return true ;

            stack[curr] = false ;
        }

        return false ;
    }

}
