package programmers;

import java.util.Arrays;

enum Move {
    N(-1,0),
    S(1,0),
    W(0,-1),
    E(0,1);

    private final int row;
    private final int col;

    Move (int row, int col) {
        this.row = row;
        this.col = col;
    }
    public int getNextRow() {
        return row;
    }
    public int getNextCol() {
        return col;
    }
}

class WalkingSolution {
    private char[][] parkMap;
    private int[] answer;

    public int[] solution(String[] park, String[] routes) {
        setParkMap(park);
        for (String command : routes) {
            String[] tokens = command.split(" ");
            int[] currPos = {answer[0], answer[1]};

            for (int i = 0; i < Integer.parseInt(tokens[1]); i++) {
                int[] move = {answer[0] + Move.valueOf(tokens[0]).getNextRow(), answer[1] + Move.valueOf(tokens[0]).getNextCol()};
                if (isNotInMap(move) || parkMap[move[0]][move[1]] == 'X') {
                    answer = currPos.clone();
                    break;
                }

                parkMap[move[0]][move[1]] = 'S';
                parkMap[answer[0]][answer[1]] = 'O';
                answer = move.clone();
            }
        }
        return answer;
    }

    public void setParkMap(String[] park) {
        answer = new int[2];
        parkMap = new char[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            parkMap[i] = park[i].toCharArray();
            for (int j = 0; j < park[0].length(); j++) {
                if (parkMap[i][j] == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
    }

    public boolean isNotInMap(int[] next) {
        return next[0] < 0 || next[0] >= parkMap.length || next[1] < 0 || next[1] >= parkMap[0].length;
    }
}
public class Walking {
    public static void main(String[] args) {
        String[] park = {"SOOXO", "OOOXO", "OXOOO", "XOOOO"};
        String[] routes = {"E 2", "S 2", "W 2", "S 1", "W 1"};
        System.out.println(Arrays.toString(new WalkingSolution().solution(park, routes)));
    }
}
