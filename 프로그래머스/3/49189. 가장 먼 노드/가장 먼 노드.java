import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] distance = new int[n + 1];
        
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        boolean visited[] = new boolean[n+1];
        
        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.offer(1);
        while(!q.isEmpty()){
            int current = q.poll();
            for(int i = 0; i < graph.get(current).size(); i++){
                int next = graph.get(current).get(i);
                if(visited[next]) continue;
                
                q.offer(next);
            visited[next] = true;
            distance[next] = distance[current] + 1;
            }
        }
        
        Arrays.sort(distance);
        int max = distance[n];
        
        for (int i : distance){
            if(i == max) answer++;
        }
        
        return answer;
    }
}