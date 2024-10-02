package baekjoon.baekjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise27481 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        char[] log = br.readLine().toCharArray();
        int[] room = new int[10];
        for (int i = 0; i < len; i++) {
            switch (log[i]) {
                case 'L' -> {
                    for (int j = 0; j < 10; j++) {
                        if (room[j] == 0) {
                            room[j] = 1;
                            break;
                        }
                    }
                }
                case 'R' -> {
                    for (int j = 9; j >= 0; j--) {
                        if (room[j] == 0) {
                            room[j] = 1;
                            break;
                        }
                    }
                }
                default -> room[log[i] - '0'] = 0;
            }
        }
        Arrays.stream(room).forEach(System.out::print);
    }
}
