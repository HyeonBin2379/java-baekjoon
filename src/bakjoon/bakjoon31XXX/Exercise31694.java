package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise31694 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] algosia = getCount(br.readLine());
        int[] bajtek = getCount(br.readLine());

        int aSum = getSum(algosia);
        int bSum = getSum(bajtek);
        if (aSum != bSum) {
            System.out.println(aSum > bSum ? "Algosia" : "Bajtek");
        } else {
            for (int i = 10; i >= 0; i--) {
                if (algosia[i] != bajtek[i]) {
                    System.out.println(algosia[i] > bajtek[i] ? "Algosia" : "Bajtek");
                    return;
                }
            }
            System.out.println("remis");
        }
    }

    public static int[] getCount(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int[] count = new int[11];
        for (int i = 0; i < 18; i++) {
            int score = Integer.parseInt(st.nextToken());
            count[score]++;
        }
        return count;
    }

    public static int getSum(int[] count) {
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            sum += i*count[i];
        }
        return sum;
    }
}
