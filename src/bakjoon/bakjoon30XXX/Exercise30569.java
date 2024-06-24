package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise30569 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] data2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double sec = 0;
        double nextFire1 = 0, nextFire2 = 0;
        while (data1[0] > 0 && data2[0] > 0) {
            if (sec >= nextFire1) {
                nextFire1 = sec + data1[2];
                data2[0] -= data1[1];
            }
            if (sec >= nextFire2) {
                nextFire2 = sec + data2[2];
                data1[0] -= data2[1];
            }
            sec += 0.5;
        }
        if (data1[0] > 0) {
            System.out.println("player one");
        } else if (data2[0] > 0) {
            System.out.println("player two");
        } else {
            System.out.println("draw");
        }
    }
}
