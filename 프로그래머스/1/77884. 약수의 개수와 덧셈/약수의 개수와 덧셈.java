class Solution {
    public int solution(int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++){
            if(isEven(i)){
                result += i;
            }
            else result -= i;
        }
        return result;
    }
    
    private static boolean isEven(int num){
        int count = 0;
        for (int i = 1; i * i <= num; i++){
            if (i * i == num) count++;
            else if (num % i == 0) count += 2;
        }
        return (count % 2 == 0); 
    }
}