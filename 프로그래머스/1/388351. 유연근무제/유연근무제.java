class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int result = 0;
        
        for (int i = 0; i < schedules.length; i++){
            int start = schedules[i];
            int end = 0;
            boolean good = true;
            
            if((start + 10) % 100 >= 60){
                end = start + 10 - 60 + 100;
            }
            else end = start + 10;
            
            int[] timelog = timelogs[i];
            
            
            for (int j = 0; j < 7; j++){
                
                int day = (startday + j - 1) % 7 + 1;  // 1~7로 고정
                if (day == 6 || day == 7) continue;    // 토(6), 일(7) skip

                
                if(end < timelog[j]) {
                    good = false;
                    break;
                }
            }
            if (good) result++;
        }
        return result;
    }
}