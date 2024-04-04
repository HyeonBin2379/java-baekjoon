package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise30617 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] knob = new int[t][2];
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            knob[i][0] = Integer.parseInt(st.nextToken());
            knob[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < t; i++) {
            if (i > 0 && knob[i-1][0] == knob[i][0] && knob[i-1][0] != 0) {
                answer++;
            }
            if (i > 0 && knob[i-1][1] == knob[i][1] && knob[i-1][1] != 0) {
                answer++;
            }
            if (knob[i][0] == knob[i][1] && knob[i][0] != 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
