class Solution{
    public boolean saveCivilians(int n, int m, char grid[][]){

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 'C') {
                if (i > 0 && grid[i-1][j] == 'T') {
                    return false;
                }
                if (i < n-1 && grid[i+1][j] == 'T') {
                    return false;
                }
                if (j > 0 && grid[i][j-1] == 'T') {
                    return false;
                }
                if (j < m-1 && grid[i][j+1] == 'T') {
                    return false;
                }
            }
        }
    }
    return true;
}
}
