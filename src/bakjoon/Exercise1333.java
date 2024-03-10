package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1333 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int time = 0;
        int answer = -1;
        while (answer < 0) {
            if (n-- > 0) {
                for (int i = time; i < time+l+5; i++) {
                    if (time+l <= i && i % d == 0) {
                        answer = i;
                        break;
                    }
                }
                time += l+5;
                continue;
            }

            if (time % d == 0) {
                answer = time;
            }
            time++;
        }
        System.out.println(answer);
    }
}
