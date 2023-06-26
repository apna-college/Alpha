/*
Given a route containing 4 direction(E,W,N,S) find the shortest path to reach destination
 */

public class String02_ShortestPath {

    public static double getShortestPath(String path) { //TC -> O(n) || n -> size of string
        char direction;
        int x = 0, y = 0;
        for(int i = 0; i < path.length(); i++) {
            direction = path.charAt(i);
            if(direction == 'N'){
                y++;
            } else if(direction == 'S') {
                y--;
            } else if(direction == 'E') {
                x++;
            } else if(direction == 'W') {
                x--;
            }
        }

        return shortestPath(x,y);
    }
    public static double shortestPath(int x, int y) {   //TC -> O(1)
        double sum = x*x + y*y;
        return Math.sqrt(sum);
    }

    public static void main(String[] args) {
        String path1 = "WNEENESENNN";
        String path2 = "SSEENNWW";
        

        System.out.println("Shortest Path >> "+ getShortestPath(path2));

    }
}
