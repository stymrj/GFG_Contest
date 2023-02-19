


class Solution {
  public:
    vector<int> juggling(vector<vector<int>> &arr, int n) {
        int wins[4] = {0}; // Array to keep track of wins for each cup

        // Loop over all possible starting cups
        for (int ball_cup = 1; ball_cup <= 3; ball_cup++) {
            int curr_cup = ball_cup;
            for (int i = 0; i < n; i++) {
                int a = arr[i][0];
                int b = arr[i][1];
                int p = arr[i][2];
                if (a == curr_cup) {
                    curr_cup = b;
                } else if (b == curr_cup) {
                    curr_cup = a;
                }
                if (curr_cup == p) {
                    wins[ball_cup]++;
                }
            }
        }

        // Find the cup with the maximum wins
        int max_wins = 0;
        int max_cup = 1;
        for (int i = 1; i <= 3; i++) {
            if (wins[i] > max_wins) {
                max_wins = wins[i];
                max_cup = i;
            }
        }

        return {max_cup, max_wins};
    }
};
