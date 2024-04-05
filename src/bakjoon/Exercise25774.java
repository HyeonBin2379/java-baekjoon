package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise25774 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] date1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] date2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int days1 = date1[0] + date1[1]*30 + date1[2]*360;
        int days2 = date2[0] + date2[1]*30 + date2[2]*360;
        int result = (days2-days1) % 7 + date1[3];
        if (result > 7) {
            System.out.println(result-7);
        } else {
            System.out.println(result);
        }
    }
}
