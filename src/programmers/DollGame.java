package programmers;

import java.util.Objects;
import java.util.Stack;

class DollGameSolution {
    private Stack<Integer>[] dolls;
    private final Stack<Integer> basket = new Stack<>();

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        dolls = new Stack[board.length];

        initialize(board);
        for (int move : moves) {
            if (dolls[move - 1].isEmpty()) {
                continue;
            }
            basket.push(dolls[move - 1].pop());
            if (basket.size() >= 2 && isContinuous()) {
                answer += 2;
                pickDolls();
            }
        }
        return answer;
    }

    public void initialize(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            dolls[i] = new Stack<>();
            for (int j = board.length-1; j >= 0; j--) {
                if (board[j][i] == 0) {
                    break;
                }
                dolls[i].push(board[j][i]);
            }
        }
    }

    public boolean isContinuous() {
        return Objects.equals(basket.get(basket.size() - 1), basket.get(basket.size() - 2));
    }
    public void pickDolls() {
        for (int i = 0; i < 2; i++) {
            basket.pop();
        }
    }
}

public class DollGame {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(new DollGameSolution().solution(board, moves));
    }
}
