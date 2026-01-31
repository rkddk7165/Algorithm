class Solution {
    static int result = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        
        return result;
    }
    
    public void dfs(int[] numbers, int target, int sum, int count){
        if (count == numbers.length) {
            if(sum == target){
                result++;
                return;
             }
            else return;
        }
        dfs(numbers, target, sum + numbers[count], count + 1);
        dfs(numbers, target, sum - numbers[count], count + 1);
    }
}