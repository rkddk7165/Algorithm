import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < days.length; i++){
            days[i] = (int)Math.ceil((100 - progresses[i]) / (double)speeds[i]);
        }
        
        int count = 1;
        int current = 0;
        for (int i = 1; i <days.length; i++){
            
            // 막힐 때
            if(days[current] >= days[i]){
                count++;
            }
            else {
                result.add(count);
                current = current + count;
                count = 1;
            }
        }
        result.add(count);
        
        int[] dap = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            dap[i] = result.get(i);
        }
        return dap;
    }
}