package programmers;

import java.util.Arrays;

class HopscotchSolution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        max = Math.max(max, land[i-1][k]);
                    }
                }
                land[i][j] += max;
            }
        }
        Arrays.sort(land[land.length-1]);
        return land[land.length-1][3];
    }
}
public class Hopscotch {
    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println(new HopscotchSolution().solution(land));
    }
}
