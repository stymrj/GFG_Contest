class Solution {
    public int[][] shortestDistanceFromTheBomb(char building[][], int n, int m) {
        int[][] result = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (building[i][j] == 'W') {
                    result[i][j] = -1;
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }

                if (building[i][j] == 'B') {
                    result[i][j] = 0;
                    queue.offer(new int[] {i, j});
                }
            }
        }


        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];

            for (int[] dir : directions) {
                int newX = currX + dir[0];
                int newY = currY + dir[1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && building[newX][newY] != 'W' && result[currX][currY] + 1 < result[newX][newY]) {
                    result[newX][newY] = result[currX][currY] + 1;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] == Integer.MAX_VALUE) {
                    result[i][j] = -1;
                }
            }
        }

        return result;
    }
}
