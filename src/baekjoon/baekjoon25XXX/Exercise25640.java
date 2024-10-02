package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise25640 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String me = br.readLine();
        int count = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < count; i++) {
            String friend = br.readLine();
            if (me.equals(friend)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
