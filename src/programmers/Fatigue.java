package programmers;

class FatigueSolution {
    private int[] selected;
    private int answer;

    public int solution(int k, int[][] dungeons) {
        selected = new int[dungeons.length];
        backtracking(dungeons, 0, k);
        return answer;
    }

    public void backtracking(int[][] dungeons, int step, int k) {
        if (step == dungeons.length) {
            int health = k;
            int count = 0;
            for (int j : selected) {
                if (dungeons[j][0] <= health) {
                    health -= dungeons[j][1];
                    count++;
                }
            }
            answer = Math.max(answer, count);
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            selected[step] = i;
            if (promising(step)) {
                backtracking(dungeons, step+1, k);
            }
        }
    }

    private boolean promising(int step) {
        for (int i = 0; i < step; i++) {
            if (selected[i] == selected[step]) {
                return false;
            }
        }
        return true;
    }
}
public class Fatigue {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(new FatigueSolution().solution(k, dungeons));
    }
}
