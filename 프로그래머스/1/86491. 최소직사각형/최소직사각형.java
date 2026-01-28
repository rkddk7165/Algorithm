class Solution {
    public int solution(int[][] sizes) {
        int size = sizes.length;
        int row_max = 0;
        int col_max = 0;
        for (int i = 0; i < size; i++){
            if (sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            row_max = Math.max(sizes[i][0], row_max);
            col_max = Math.max(sizes[i][1], col_max);
        
    }
        return row_max * col_max;
}
}