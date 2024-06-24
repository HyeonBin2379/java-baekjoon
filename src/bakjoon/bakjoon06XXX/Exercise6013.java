package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise6013 {
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cow = Integer.parseInt(br.readLine());
        int[][] pos = new int[cow][2];
        for (int i = 0; i < cow; i++) {
            pos[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int maxDist = 0;
        for (int i = 0; i < cow; i++) {
            for (int j = i+1; j < cow; j++) {
                int dist = getDistance(pos[i], pos[j]);
                if (maxDist < dist) {
                    maxDist = dist;
                    answer = new int[]{i+1, j+1};
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }

    public static int getDistance(int[] cow1, int[] cow2) {
        return (cow1[0]-cow2[0])*(cow1[0]-cow2[0]) + (cow1[1]-cow2[1])*(cow1[1]-cow2[1]);
    }
}
