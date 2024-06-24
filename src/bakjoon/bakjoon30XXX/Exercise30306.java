package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise30306 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] dice1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dice2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int first = 0, second = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (dice1[i] == dice2[j]) {
                    continue;
                }

                if (dice1[i] > dice2[j]) {
                    first++;
                } else {
                    second++;
                }
            }
        }

        if (first > second) {
            System.out.println("first");
        } else if (first == second) {
            System.out.println("tie");
        } else {
            System.out.println("second");
        }
    }
}
