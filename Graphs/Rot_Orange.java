// assignment(1) - 3

package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Rot_Orange {
    public static void main(String[] args) {
        int arr[][] = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(rotten(arr));
    }

    public static int row = 3 ;
    public static int col = 3 ;

    static class Ele{
        int x = 0 ;
        int y = 0 ;
        public Ele(int x,int y){
            this.x = x; 
            this.y = y ;
        }
    }

    public static boolean isValid(int i,int j){
        return i >= 0 && j >= 0 && i < row && j < col ;
    }

    public static boolean isFresh(int arr[][]){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(arr[i][j] == 1)
                return true ;
            }
        }
        return false ;
    }

    public static boolean isDelim(Ele temp){
        return (temp.x == -1 && temp.y == -1 ) ;
    }
    
    public static int rotten(int arr[][]){

        Queue<Ele> q = new LinkedList<>();
        int ans = 0 ;
        Ele temp ;

        for(int i= 0 ; i<row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(arr[i][j] == 2)
                q.add(new Ele(i, j));
            }
        }
        q.add(new Ele(-1, -1));

        while (!q.isEmpty()) {
            boolean flag = false;

            while (!isDelim(q.peek())) {
                temp  = q.peek();

                if(isValid(temp.x+1, temp.y) && arr[temp.x+1][temp.y] == 1){
                    if(!flag){
                        ans++ ;
                        flag = true ;
                    }
                    arr[temp.x+1][temp.y] = 2 ;
                    temp.x++;
                    q.add(new Ele(temp.x, temp.y)) ;
                    temp.x -- ;
                }
                if(isValid(temp.x-1, temp.y) && arr[temp.x-1][temp.y] == 1){
                    if(!flag){
                        ans++ ;
                        flag = true ;
                    }
                    arr[temp.x-1][temp.y] = 2 ;
                    temp.x --;
                    q.add(new Ele(temp.x, temp.y)) ;
                    temp.x ++ ;
                }
                if(isValid(temp.x, temp.y+1) && arr[temp.x][temp.y+1] == 1){
                    if(!flag){
                        ans++ ;
                        flag = true ;
                    }
                    arr[temp.x][temp.y+1] = 2 ;
                    temp.y ++;
                    q.add(new Ele(temp.x, temp.y)) ;
                    temp.y -- ;
                }
                if(isValid(temp.x, temp.y-1) && arr[temp.x][temp.y-1] == 1){
                    if(!flag){
                        ans++ ;
                        flag = true ;
                    }
                    arr[temp.x][temp.y-1] = 2 ;
                    temp.x --;
                    q.add(new Ele(temp.x, temp.y)) ;
                    temp.x ++ ;
                }
                q.remove();
            }
            q.remove();

            if(!q.isEmpty())
            q.add(new Ele(-1, -1));
        }

        return isFresh(arr) ? -1 : ans ;
    }
}
