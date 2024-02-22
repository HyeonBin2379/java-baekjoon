package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise26068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int answer = count;
        for (int i = 0; i < count; i++) {
            String d_day = br.readLine();
            if (Integer.parseInt(d_day.substring(2)) > 90) {
                answer--;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
