class Solution {
    public int solution(String[] babbling) {

        String[] list = {"aya", "ye", "woo", "ma"};
        int count = 0;
        
        for (String s: babbling){
            for (String ss: list){
                String temp = s.replace(ss, " ");
                s = temp;
            }
            if (s.isBlank()) count++;

        }
        return count;
    }
}