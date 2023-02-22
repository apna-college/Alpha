package Graphs;
import java.util.*;


public class Bipitarite_graph {
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
    
    public static void main(String[] args) {
        int v = 5 ;
        ArrayList<Edge> graph[] = new ArrayList [v]; // this array is empty so, we have to fill with arraylist

        for(int i=0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<>();
        }

        // 0 - vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        //graph[0].add(new Edge(0, 3, 1));

        //1 - vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2 - vertex
        graph[2].add(new Edge(2,0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3 - vertex
        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 2, 1));

        System.out.println(isBipitarite(graph));
    }

    public static boolean isBipitarite(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();

        int col[] = new int[graph.length];

        for(int i=0 ; i<col.length ; i++)
        col[i] = -1 ;

        for(int i=0 ; i< graph.length ; i++){
            if(col[i] == -1){
                q.add(i);
                col[i] = 0 ; // give color
                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for(int j=0 ; j< graph[curr].size() ; j++){
                        Edge e = graph[curr].get(j);
                        if(col[e.destination] == -1){
                            int newcolor = col[curr] == 0 ? 1 : 0 ;
                            col[e.destination]  = newcolor ;
                            q.add(e.destination);
                        }
                        else if(col[e.destination] == col[curr])
                        return false;
                    }
                }
            }
            
        }
        return true ;
    }
}
