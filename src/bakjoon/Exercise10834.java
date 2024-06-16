package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise10834 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int direction = 0;
        long rotation = 1;

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int s = Integer.parseInt(input[2]);
            if (s == 1) {
                direction = 1 - direction;
            }
            rotation = rotation * b / a;
        }

        System.out.println(direction + " " + rotation);
    }
}
