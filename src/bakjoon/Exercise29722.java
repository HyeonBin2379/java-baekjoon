package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise29722 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] date = Arrays.stream(br.readLine().split("-")).mapToInt(Integer::parseInt).toArray();
        int days = Integer.parseInt(br.readLine());
        int[] temp = {12, 30};
        date[2] += days;
        for (int i = 2; i >= 1; i--) {
            date[i-1] += (date[i]-1) / temp[i-1];
            date[i] = (date[i]-1) % temp[i-1] + 1;
        }
        System.out.printf("%02d-%02d-%02d\n", date[0], date[1], date[2]);
    }
}
