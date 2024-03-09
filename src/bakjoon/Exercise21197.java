package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise21197 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pushed = Integer.parseInt(br.readLine());
        int[] button = new int[pushed];
        for (int i = 0; i < pushed; i++) {
            button[i] = Integer.parseInt(br.readLine());
        }

        int sec = 0, run = 0, idx = 0;
        boolean running = false;
        while (idx != pushed) {
            if (running) {
                run++;
            }
            if (button[idx] == sec) {
                idx++;
                running = !running;
            }
            sec++;
        }
        System.out.println(running ? "still running" : run);
    }
}
