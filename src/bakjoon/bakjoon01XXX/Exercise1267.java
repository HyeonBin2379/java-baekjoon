package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] callTime = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int youngSik = 0;
        int minSik = 0;
        for (int j : callTime) {
            youngSik += (j / 30 + 1) * 10;
            minSik += (j / 60 + 1) * 15;
        }

        if (youngSik > minSik) {
            System.out.print("M ");
            System.out.println(minSik);
        } else if (youngSik < minSik) {
            System.out.print("Y ");
            System.out.println(youngSik);
        } else {
            System.out.print("Y M ");
            System.out.println(youngSik);
        }
        br.close();
    }
}
