package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dog = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] time = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i : time) {
            int count = 0;
            int x = (i % (dog[0] + dog[1]) == 0) ? (dog[0] + dog[1]) : i % (dog[0] + dog[1]);
            int y = (i % (dog[2] + dog[3]) == 0) ? (dog[2] + dog[3]) : i % (dog[2] + dog[3]);

            if (x <= dog[0]) {
                count++;
            }
            if (y <= dog[2]) {
                count++;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
