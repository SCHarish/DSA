// There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// The test cases are generated so that the answer will be less than or equal to 2 * 109.


class Solution {
    
    //     public int countPaths(int i, int j, int m, int n){
            
    //         //base case
    //         if(i > m || j > n)
    //             return 0;
            
    //         if(i == m-1 && j == n-1){
    //             return 1;
    //         }
            
            
    //         return countPaths(i+1, j, m, n) + countPaths(i, j+1, m, n);
    //     }
        
        public int countPaths(int i, int j, int m, int n, int dp[][]){
            //base case
            if(i > m || j > n)
                return 0;
            
            if(i == m  && j == n)
                return 1;
            
            if(dp[i][j] != -1)
                return dp[i][j];
            
            dp[i][j] = countPaths(i+1, j, m, n, dp) + countPaths(i, j+1, m, n, dp);
            return dp[i][j];
        }
        
        public int uniquePaths(int m, int n) {
            // recursive solution
            // return countPaths(0, 0, m, n);
            
            int dp[][] = new int[m][n];
            //init dp matrix
            for(int i=0;i<m;i++){
                dp[i] = new int[n];
            }
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    dp[i][j] = -1;
                }
            }
            
            return countPaths(0, 0, m-1, n-1, dp);
        }
    }