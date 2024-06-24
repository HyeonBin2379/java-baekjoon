package bakjoon.bakjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise5074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("00:00 00:00")) {
                break;
            }
            int[] time = Arrays.stream(input.split("[^0-9]")).mapToInt(Integer::parseInt).toArray();
            int sum = (time[0]+time[2])*60 + (time[1]+time[3]);
            sb.append(String.format("%02d:%02d ", (sum % 1440)/60, (sum % 60)));
            sb.append((sum / 1440 > 0) ? String.format("+%d\n", sum/1440) : "\n");
        }
        System.out.print(sb);
    }
}
