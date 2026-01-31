import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String result = "";
        Map<String, Integer> m = new HashMap<>();
        
        for (int i = 0; i < participant.length; i++){
            if(!m.containsKey(participant[i])) m.put(participant[i], 1);
            else m.put(participant[i], m.get(participant[i]) + 1);
        }
        
        for (int i = 0; i < completion.length; i++){
            m.put(completion[i], m.get(completion[i]) - 1);
        }
        
        for(String key : m.keySet()) {
            if(m.get(key).equals(1)) {
                result = key;
                break;
            }
        }
        return result;
    }
}