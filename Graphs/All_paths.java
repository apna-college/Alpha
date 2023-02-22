// all paths from source to destination

package Graphs;

import java.util.ArrayList;

public class All_paths {
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
        ArrayList<Edge> graph[] = new ArrayList [6]; // this array is empty so, we have to fill with arraylist

        for(int i=0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<>();
        }
    
        graph[0].add(new Edge(0, 3, 1));
        graph[2].add(new Edge(2, 3, 1));

        // 3 - vertex
        graph[3].add(new Edge(3, 1, 1));

        // 4 - vertex
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));

        printAllPath(graph, 5, 1, "");
    }

    public static void printAllPath(ArrayList<Edge>[] graph,int src,int dest,String path){
        if(src == dest){
            System.out.println(path += dest);
            return ;
        }

        for(int i=0 ; i< graph[src].size() ;i++){
            Edge e = graph[src].get(i);

            printAllPath(graph, e.destination, dest, path+src);
        }
    }
}
