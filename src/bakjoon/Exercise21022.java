package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise21022 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int round = Integer.parseInt(br.readLine());
        int[] binus = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] opponent = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int total = 0;
        for (int i = 0; i < round; i++) {
            if (binus[i] > opponent[i]) {
                total += 3;
            } else if (binus[i] == opponent[i]) {
                total += 1;
            }
        }
        System.out.println(total);
    }
}
