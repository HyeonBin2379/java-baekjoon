package baekjoon.baekjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise7782 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] spaceship = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int b1_x = Integer.parseInt(st.nextToken());
            int b1_y = Integer.parseInt(st.nextToken());
            int b2_x = Integer.parseInt(st.nextToken());
            int b2_y = Integer.parseInt(st.nextToken());

            if ((b1_x <= spaceship[0] && spaceship[0] <= b2_x)
                    || (b1_y <= spaceship[1] && spaceship[1] <= b2_y)) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
