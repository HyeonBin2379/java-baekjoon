package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise5940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i = a+1; i <= 62; i++) {
            if (Long.toString((long)Math.pow(2, i)).startsWith(String.valueOf(b))) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
