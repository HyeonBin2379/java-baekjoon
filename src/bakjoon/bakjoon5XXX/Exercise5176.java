package bakjoon.bakjoon5XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise5176 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Set<Integer> attendee = new TreeSet<>();
            for (int j = 0; j < p; j++) {
                int seatNum = Integer.parseInt(br.readLine());
                if (seatNum >= 1 && seatNum <= m) {
                    attendee.add(seatNum);
                }
            }
            System.out.println(p - attendee.size());
        }
    }
}
