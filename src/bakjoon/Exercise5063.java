package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise5063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int[] rec = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (rec[0] < (rec[1]-rec[2])) {
                sb.append("advertise\n");
            } else if (rec[0] == (rec[1]-rec[2])) {
                sb.append("does not matter\n");
            } else {
                sb.append("do not advertise\n");
            }
        }
        System.out.print(sb);
    }
}
