package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2530 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] time = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] inc = new int[3];
        inc[2] = Integer.parseInt(br.readLine());
        br.close();

        inc[0] = inc[2] / 3600;
        inc[1] = (inc[2] % 3600) / 60;
        inc[2] %= 60;
        for (int i = inc.length-1; i >= 0; i--) {
            int timeUnit = (i == 0) ? 24 : 60;
            time[i] += inc[i];
            if (i > 0) {
                time[i-1] += (time[i] / 60);
            }
            time[i] = (time[i] >= timeUnit) ? time[i] % timeUnit : time[i];
        }
        Arrays.stream(time).forEach(value -> System.out.print(value + " "));
    }
}