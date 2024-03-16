package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise30544 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] time = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int count = Integer.parseInt(br.readLine());
        if (time[1] % 15 == 0) {
            count -= (time[1] == 0) ? time[0] : 1;
        } else if (time[1] < 45) {
            time[1] = (int)((double)time[1]/15 + 1)*15;
            count--;
        } else {
            time[1] = 0;
            time[0] += 1;
            count -= time[0];
        }

        while (count > 0) {
            time[1] += 15;
            if (time[1] != 60) {
                count--;
                continue;
            }
            time[1] = 0;
            time[0] = (time[0]+1 > 12) ? (time[0]+1) % 12 : time[0]+1;
            count -= time[0];
        }
        System.out.printf("%02d:%02d\n", time[0], time[1]);
    }
}
