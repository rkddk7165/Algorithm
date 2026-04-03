import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        boolean exists = false;
        
        for (String word : words) {
            if (word.equals(target)) {
                exists = true;
                break;
            }
        }
        
        if (!exists) return 0;
        
        return bfs(begin, target, words);
    }
    
    public int bfs(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> countQueue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        queue.offer(begin);
        countQueue.offer(0);
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            int count = countQueue.poll();
            
            if (current.equals(target)) {
                return count;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                
                if (canChange(current, words[i])) {
                    visited[i] = true;
                    queue.offer(words[i]);
                    countQueue.offer(count + 1);
                }
            }
        }
        
        return 0;
    }
    
    public boolean canChange(String a, String b) {
        int diff = 0;
        
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        
        return diff == 1;
    }
}