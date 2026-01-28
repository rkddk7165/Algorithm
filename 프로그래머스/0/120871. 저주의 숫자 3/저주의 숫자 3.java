class Solution {
    public int solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++){
            
            while((i + count) % 3 == 0 || Integer.toString(i + count).contains("3")){
                count++;
            }
        }
        
        return n + count;
    }
}