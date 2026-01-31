import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    static int[][] map;
    static int N, M;
    static boolean[][] visited;
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i ++){
            for (int j = 0; j < M; j++){
                map[i][j] = maps[i][j];
            }
        }
        
        return bfs(0, 0);
        
    }
    
    public int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 1));
        visited[x][y] = true;
        
        while (!q.isEmpty()){
            Node node = q.poll();
            if (node.x == N - 1 && node.y == M - 1){
                return node.cost;
            }
            for (int i = 0; i < 4; i++){
                int curX = node.x + dx[i];
                int curY = node.y + dy[i];
                
                if (curX < 0 || curY < 0 || curX >= N || curY >= M){
                    continue;
                }
                if (map[curX][curY] == 0 || visited[curX][curY]) {
                    continue;
                }
                
                visited[curX][curY] = true;
                q.offer(new Node(curX, curY, node.cost + 1));
                
            }
        }
        return -1;
        
    }
    
    public class Node{
        int x;
        int y;
        int cost;
        
        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}