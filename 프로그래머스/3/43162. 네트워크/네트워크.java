class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[computers.length];
        int answer = 0;
        
        for (int i = 0; i < n; i++){
            answer += dfs(n, i, computers);
        }
        
        return answer;
    }
    
    public static int dfs(int n, int start, int[][]computers){
        
        if(visited[start]){
            return 0;
        }
        
        visited[start] = true;
        
        for (int i = 0; i < n; i++){
            if(!visited[i] && start != n && computers[start][i] == 1){
                dfs(n, i, computers);
            }
        }
        return 1;
    }
}