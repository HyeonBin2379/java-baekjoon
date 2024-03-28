package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise13221 {

    private static int[] answer = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] me = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            int[] taxi = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int dist = Math.abs(me[0]-taxi[0]) + Math.abs(me[1]-taxi[1]);
            if (dist < min) {
                min = dist;
                answer = taxi.clone();
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
