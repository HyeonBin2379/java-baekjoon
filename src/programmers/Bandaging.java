package programmers;

import java.util.Map;
import java.util.TreeMap;

class BandagingSolution {
    private final Map<Integer, Integer> monsterMove = new TreeMap<>();

    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        for (int[] attack : attacks) {
            monsterMove.put(attack[0], attack[1]);
        }

        int turn = 0;
        int bandageCombo = 0;
        while (turn < attacks[attacks.length-1][0]) {
            turn++;
            if (monsterMove.containsKey(turn)) {
                answer -= monsterMove.get(turn);
                bandageCombo = 0;
                if (answer <= 0) {
                    return -1;
                }
                continue;
            }

            if (answer <= health) {
                answer += Math.min(bandage[1], health-answer);
                bandageCombo++;
                if (bandageCombo == bandage[0]) {
                    answer += Math.min(bandage[2], health-answer);
                    bandageCombo = 0;
                }
            }
        }
        return answer;
    }
}
public class Bandaging {
    public static void main(String[] args) {
        int[] bandage = {1, 1, 1};
        int health = 5;
        int[][] attacks = {{1, 2}, {3, 2}};
        System.out.println(new BandagingSolution().solution(bandage, health, attacks));
    }
}
