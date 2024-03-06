package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise28288 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int attendee = Integer.parseInt(br.readLine());
        char[][] schedule = new char[attendee][5];
        int[] attendByDays = new int[5];
        int max = 0;
        for (int i = 0; i < attendee; i++) {
            schedule[i] = br.readLine().toCharArray();
            for (int j = 0; j < 5; j++) {
                attendByDays[j] += (schedule[i][j] == 'Y') ? 1 : 0;
            }
            max = Arrays.stream(attendByDays).max().getAsInt();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if (attendByDays[i] == max) {
                if (sb.isEmpty()) {
                    sb.append(i+1);
                } else {
                    sb.append(",").append(i+1);
                }
            }
        }
        System.out.println(sb);
    }
}
