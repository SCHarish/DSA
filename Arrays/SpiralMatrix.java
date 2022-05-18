class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row_min = 0 , row_max = matrix.length-1, 
            col_min = 0, col_max = matrix[0].length-1;
        
        List<Integer> result = new ArrayList<>();
        
    
        while(row_min <= row_max && col_min <= col_max){
            
            for(int i=col_min;i<=col_max;i++){
                result.add(matrix[row_min][i]);
            }
            row_min++;
            
            for(int i=row_min;i<=row_max;i++){
                result.add(matrix[i][col_max]);
            }
            col_max--;
            
            if(row_min <= row_max){
                for(int i=col_max;i>=col_min;i--){
                    result.add(matrix[row_max][i]);
                }
            }
            
            row_max--;
            
            if(col_min <= col_max){
            
                for(int i=row_max;i>=row_min;i--){
                    result.add(matrix[i][col_min]);
                }
            }
            
            col_min++;
        }
        
        return result;
        
      
    }
}