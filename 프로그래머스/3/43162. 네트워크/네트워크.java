import java.util.*;

class Solution {
    static boolean [] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int start = 0; start < n; start++){
            if(!visited[start]) {
                dfs(start, computers, n);
                answer++;
            }
        }
        return answer;
    }
    
    private static void dfs(int start, int[][] computers, int n){
        visited[start] = true;
        
        for (int i = 0; i < n; i++){
            if(start == i) continue;
            if(computers[start][i] == 1 && !visited[i]){
                dfs(i, computers, n);
            }
        }
    }
        

    
}