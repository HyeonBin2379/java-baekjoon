package programmers;

class AdjacentSpaceSolution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int[] next : move) {
            int dh = h + next[0];
            int dw = w + next[1];
            if (dh >= 0 && dh < board.length && dw >= 0 && dw < board.length) {
                if (board[h][w].equals(board[dh][dw])) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
public class AdjacentSpace {
    public static void main(String[] args) {
        String[][] board = {
                {"blue", "red", "orange", "red"},
                {"red", "red", "blue", "orange"},
                {"blue", "orange", "red", "red"},
                {"orange", "orange", "red", "blue"}
        };
        int h = 1;
        int w = 1;
        AdjacentSpaceSolution result = new AdjacentSpaceSolution();
        System.out.println(result.solution(board, h, w));
    }
}
