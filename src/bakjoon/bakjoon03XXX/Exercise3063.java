package bakjoon.bakjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise3063 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] pos1 = new int[4];
            for (int j = 0; j < 4; j++) {
                pos1[j] = Integer.parseInt(st.nextToken());
            }
            int[] pos2 = new int[4];
            for (int j = 0; j < 4; j++) {
                pos2[j] = Integer.parseInt(st.nextToken());
            }

            int answer = (pos1[2]-pos1[0])*(pos1[3]-pos1[1])
                    - Math.max((Math.min(pos1[3], pos2[3])-Math.max(pos1[1], pos2[1])), 0)
                    * Math.max((Math.min(pos1[2], pos2[2])-Math.max(pos1[0], pos2[0])), 0);
            System.out.println(answer);
        }
    }
}
