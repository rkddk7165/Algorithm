import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int len = answers.length;
        
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        
        int count1 = 0, count2 = 0, count3 = 0;
        
        for (int i = 0; i < len; i++){
            if(answers[i] == arr1[i % arr1.length]) count1++;
            if(answers[i] == arr2[i % arr2.length]) count2++;
            if(answers[i] == arr3[i % arr3.length]) count3++;
        }
        
        List<Integer> list = new ArrayList<>();
        
        int maxScore = Math.max(Math.max(count1, count2), count3);
        if (count1 == maxScore) list.add(1);
        if (count2 == maxScore) list.add(2);
        if (count3 == maxScore) list.add(3);
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}