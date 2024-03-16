package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1440 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] time = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i == j || j == k || k == i) {
                        continue;
                    }
                    if ((time[i] > 0 && time[i] < 13)
                            && (time[j] >= 0 && time[j] < 60)
                            && (time[k] >= 0 && time[k] < 60)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
