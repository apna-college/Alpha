// topological sorting using bfs passion
// problem in leetcode course schedule II

package Graphs;

import java.util.*;

public class TopoSorting_Using_BFS {

    public static void findInDeegree(ArrayList<Edge> graph[],int inDeg[]){
        for(int i=0; i < graph.length ; i++){
            int vertex = i;
            for(int j=0; j < graph[vertex].size() ; j++){
                Edge e = graph[vertex].get(j);
                inDeg[e.destination]++;
            }
        }
    }

    public static void topological_sort(ArrayList<Edge> graph[]){
        int inDeg[] = new int[graph.length];
        findInDeegree(graph, inDeg);
        Queue<Integer> q = new LinkedList<>();

        // if pehle se jiski indeegree 0 ho usko queue me add kardo
        for (int i = 0; i < inDeg.length; i++) {
            if(inDeg[i] == 0)
            q.add(i);
        }

        // neighbour indegree kam karo
        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDeg[e.destination]--; // neighbour ko minus kardo kyuki inka parent add ho chuka he to matlb 1 gaya to 1 indeegerre minus

                if(inDeg[e.destination] == 0)
                q.add(e.destination);
            }
        }
    }

    
    public static void main(String[] args) {
        int v = 6;
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

        topological_sort(graph);
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
}
