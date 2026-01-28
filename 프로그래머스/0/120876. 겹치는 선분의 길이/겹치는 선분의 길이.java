class Solution {
    public int solution(int[][] lines) {
        int[] list = new int[201];
        int result = 0;
        for(int[] n : lines){
            for (int i = n[0] + 100; i < n[1] + 100; i++){
                list[i]++;
            }
        }
        
        for (int n : list){
            if(n >= 2) result++;
        }
        
        return result;
    }
    
}