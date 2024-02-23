package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise18414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        int answer = data[1];
        int min = data[0];
        for (int i = data[1]; i <= data[2]; i++) {
            if (Math.abs(data[0]-i) < min) {
                min = data[0]-i;
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
