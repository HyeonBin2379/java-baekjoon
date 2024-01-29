package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HanoiTowerSolution {
    private final List<int[]> sequence = new ArrayList<>();

    public int[][] solution(int n) {
        move(n, 1, 3, 2);

        int[][] answer = new int[(1 << 2) - 1][2];
        for (int i = 0; i < answer.length; i++) {
            int[] temp = sequence.get(i);
            answer[i][0] = temp[0];
            answer[i][1] = temp[1];
        }
        return answer;
    }

    public void move(int num, int from, int to, int via) {
        int[] next = {from, to};

        if (num == 1) {
            sequence.add(next);
        } else {
            move(num - 1, from, via, to);
            sequence.add(next);
            move(num - 1, via, to, from);
        }
    }
}
public class HanoiTower {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new HanoiTowerSolution().solution(2)));
    }
}
