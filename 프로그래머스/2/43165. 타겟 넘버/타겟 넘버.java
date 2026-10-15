class Solution {
    static int result = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(0, numbers, 0, target);
        
        return result;
    }
    
    private static void dfs(int sum, int[] numbers, int count, int target){
        if(count == numbers.length){
            if(sum == target) {
                result++;
                return;
            }
            return;
        }
        
        dfs(sum + numbers[count], numbers, ++count, target);
        
        dfs(sum - numbers[--count], numbers, ++count, target);
    }
}