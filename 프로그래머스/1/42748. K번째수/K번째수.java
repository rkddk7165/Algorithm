class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] result = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++){
            int arrLen = commands[i][1] - commands[i][0] + 1;
            
            int[] arr = new int[arrLen];
            for (int j = 0; j < arrLen; j++){
                arr[j] = array[j + commands[i][0] - 1];
            }
            
            if (arr.length == 1) {
                result[i] = arr[commands[i][2] - 1];
                continue;
            }
            
            // k번째까지 선택정렬 후 k번째로 작은 값 result에 추가
            for (int j = 0; j < arrLen; j++){
    int minIdx = j;

    for (int k = j + 1; k < arrLen; k++){
        if (arr[k] < arr[minIdx]) minIdx = k;
    }

    int tmp = arr[minIdx];
    arr[minIdx] = arr[j];
    arr[j] = tmp;

    if (j + 1 == commands[i][2]){
        result[i] = arr[j];
        break;
    }
}
        }
        return result;
    }
}