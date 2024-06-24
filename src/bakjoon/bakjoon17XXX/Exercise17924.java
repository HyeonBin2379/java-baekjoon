package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise17924 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        int[][] range = new int[testCase][2];
        for (int i = 0; i < testCase; i++) {
            range[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i <= 10000; i++) {
            int boilingTime = i;
            if (Arrays.stream(range).allMatch(ints -> boilingTime >= ints[0] && boilingTime <= ints[1])) {
                System.out.println("gunilla has a point");
                return;
            }
        }
        System.out.println("edward is right");
    }
}
