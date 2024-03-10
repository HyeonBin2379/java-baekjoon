package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise29991 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] fatigue = new int[c];
        for (int i = 0; i < c; i++) {
            fatigue[i] = Integer.parseInt(br.readLine());
        }
        int[] cool = new int[r];
        for (int i = 0; i < r; i++) {
            cool[i] = Integer.parseInt(br.readLine());
        }

        int i = 0, j = 0;
        int answer = 0;
        while (i != c && j != r) {
            d += (d-fatigue[i] >= 0) ? -fatigue[i++] : cool[j++];
            answer++;
        }

        if (i == c) {
            answer += (r-j);
        }
        if (j == r) {
            while (d-fatigue[i] >= 0) {
                d -= fatigue[i++];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
